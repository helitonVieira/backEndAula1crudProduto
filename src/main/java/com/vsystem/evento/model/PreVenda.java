package com.vsystem.evento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TAB_PRE_VENDA")
public class PreVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_pre_venda")
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(name="dta_pre_venda")
	private Date dtaPreVenda;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(name="dta_validade")
	private Date dtaValidade;
	
	@Column(name="ind_status")
	private String status;

	@ManyToOne
	@JoinColumn(name="cod_pessoa")
	private Cliente cliente;	
	
	@OneToMany(mappedBy="id.preVenda")
	@Column(name="cod_item_pre_venda")
	private Set<ItemPreVenda> itens = new HashSet<>();	
	
	
	public PreVenda() {
		
	}

	public PreVenda(Integer id, Date dtaPreVenda, Date dtaValidade, String status, Cliente cliente) {
		super();
		this.id = id;
		this.dtaPreVenda = dtaPreVenda;
		this.dtaValidade = dtaValidade;
		this.status = status;
		this.cliente = cliente;
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

	public Set<ItemPreVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPreVenda> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreVenda other = (PreVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
