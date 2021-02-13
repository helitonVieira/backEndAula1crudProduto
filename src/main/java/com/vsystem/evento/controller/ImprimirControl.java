package com.vsystem.evento.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class ImprimirControl {
	
	// variavel estatica porque será utilizada por inumeras threads
		private static PrintService impressora;

		public void Impressao() {
			detectaImpressoras();
		}

		// O metodo verifica se existe impressora conectada e a
		// define como padrao.
		public void detectaImpressoras() {
			try {
				DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
				PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
				for (PrintService p : ps) {
					if(p.getName()!=null && p.getName().contains("ELGIN i9(USB)")){
						System.out.println("Impressora Selecionada: " + p.getName());
						System.out.println("Impressora encontrada: " + p.getName());
						impressora = p;
					}	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@GetMapping(value="/imprimir/{msg}")		
		public  void imprimir( @PathVariable String msg){
			detectaImpressoras();
			imprime(msg);
		}
			
		
				
				
		public synchronized boolean imprime( String msg1) {
			System.out.println(msg1);
			// se nao existir impressora, entao avisa usuario
			// senao imprime texto
			if (impressora == null) {
				String msg = "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.";
				System.out.println(msg);
			} else {
				try {
					DocPrintJob dpj = impressora.createPrintJob();
					InputStream stream = new ByteArrayInputStream(msg1.getBytes());
					DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
					Doc doc = new SimpleDoc(stream, flavor, null);
					dpj.print(doc, null);
					return true;
				} catch (PrintException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
		/*public static void main(String[] args) {
			new Impressao().imprime("teste pedrosa dfsdfsdfsdffsdfsfdffsf" + System.getProperty("line.separator") + "asdad");
		}*/

}
