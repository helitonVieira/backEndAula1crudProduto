package com.vsystem.evento.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPreVendaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="cod_pre_venda")
	private PreVenda preVenda;
	
	@ManyToOne
	@JoinColumn(name="cod_item")
	private Produto produto;

	public PreVenda getPreVenda() {
		return preVenda;
	}

	public void setPreVenda(PreVenda preVenda) {
		this.preVenda = preVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preVenda == null) ? 0 : preVenda.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemPreVendaPK other = (ItemPreVendaPK) obj;
		if (preVenda == null) {
			if (other.preVenda != null)
				return false;
		} else if (!preVenda.equals(other.preVenda))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}	
	

}
