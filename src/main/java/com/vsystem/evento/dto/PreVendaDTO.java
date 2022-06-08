package com.vsystem.evento.dto;

import java.io.Serializable;
import java.util.Date;

import com.vsystem.evento.model.Cliente;
import com.vsystem.evento.model.PreVenda;

public class PreVendaDTO implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private Integer id;	
		private Date dtaPreVenda;	
		private Date dtaValidade;
		private String status;		
		private Cliente cliente;
	
		public PreVendaDTO() {
			
		}		
				
		public PreVendaDTO(PreVenda obj) {
			id = obj.getId();
			dtaPreVenda = obj.getDtaPreVenda();
			dtaValidade = obj.getDtaValidade();
			status = obj.getStatus();
			cliente = obj.getCliente();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Date getDtaPreVenda() {
			return dtaPreVenda;
		}

		public void setDtaPreVenda(Date dtaPreVenda) {
			this.dtaPreVenda = dtaPreVenda;
		}
		
		public Date getDtaValidade() {
			return dtaValidade;
		}

		public void setDtaValidade(Date dtaValidade) {
			this.dtaValidade = dtaValidade;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}	
		
}
