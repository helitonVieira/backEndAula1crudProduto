package com.vsystem.evento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tab_item_pre_venda")
public class ItemPreVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPreVendaPK id = new ItemPreVendaPK();
	
	@Column(name="val_desconto")
	private Double desconto;
	
	@Column(name="qtd_item")
	private Integer quantidade;
	
	@Column(name="val_unitario")
	private Double valorUnitario;
	
	@Column(name="val_total")
	private Double valorTotal;

	
	public ItemPreVenda() {
		
	}
	
	public ItemPreVenda(ItemPreVendaPK id, Double desconto, Integer quantidade, Double valorUnitario,
			Double valorTotal) {
		super();
		this.id = id;
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}

	public ItemPreVendaPK getId() {
		return id;
	}

	public void setId(ItemPreVendaPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
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
		ItemPreVenda other = (ItemPreVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
	


}
