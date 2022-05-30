package com.vsystem.evento.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.vsystem.evento.model.Cliente;
import com.vsystem.evento.model.Produto;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}") //buscando valor do aplication.properties
	private String sender;
	
	@Value("${default.recipient}") //buscando valor do aplication.properties\n"
			private String recipient;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOrderConfirmationEmail(Produto obj) {   //serve para mock e para SMTP 
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Produto obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		//sm.setTo(obj.getCliente().getEmail());  
		sm.setTo(recipient);//destinatario
		sm.setFrom(sender); //remetente
		sm.setSubject("Cadastro de Produto! Código: " + obj.getId()); // Assunto do email
		sm.setSentDate(new Date(System.currentTimeMillis())); //garantindo envio da data com horario do servidor 
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromTemplatePedido(Produto obj) {
		Context context = new Context();
		context.setVariable("produto", obj); //enviando para o html (apelidoQueVaiParaHtml , dados)
		return templateEngine.process("email/confirmacaoProduto", context); //processar o html retornando na forma de string
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Produto obj) {   //serve para mock e para SMTP 
		try {		
			MimeMessage mm = prepareMimeMessageFromPedido(obj);
			sendHtmlEmail(mm);
		}
		catch (MessagingException e ) {
			sendOrderConfirmationEmail(obj); // tentar enviar via html se der erro envia via smtp(texto plano)
		}
	}

	protected  MimeMessage prepareMimeMessageFromPedido(Produto obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage , true);
		mmh.setTo(recipient);//destinatario
		mmh.setFrom(sender); //remetente
		mmh.setSubject("Cadastro de Produto! Código: " + obj.getId()); // Assunto do email
		mmh.setSentDate(new Date(System.currentTimeMillis())); //garantindo envio da data com horario do servidor 
		mmh.setText(htmlFromTemplatePedido(obj),true);
		return mimeMessage;
	}
	
	@Override
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(cliente.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}
}
