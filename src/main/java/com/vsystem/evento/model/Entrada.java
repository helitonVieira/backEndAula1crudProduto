package com.vsystem.evento.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tab_entrada")
public class Entrada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="seq_entrada")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	Integer id ; 
	
	@Column(name="num_entrada")
	int numEntrada;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime dtaAdmissao; 
	
	@Column(name="ind_entrada_saida")
	String indEntSaid;
	
	@Column(name="qtd_item")
	double quantidade;
	
	@Column(name="val_unitario")
	double valUnitario;
	
	@Column(name="val_total")
	double valTotal;
	
	@ManyToOne	
	@JoinColumn(name="cod_item")
	private Produto produto;
	
	public Entrada() {
		
	}	

	public Entrada(Integer id, int numEntrada, LocalDateTime dtaAdmissao,
			String indEntSaid, double quantidade, double valUnitario,
			double valTotal, Produto produto) {
		super();
		this.id = id;
		this.numEntrada = numEntrada;
		this.dtaAdmissao = dtaAdmissao;
		this.indEntSaid = indEntSaid;
		this.quantidade = quantidade;
		this.valUnitario = valUnitario;
		this.valTotal = valTotal;
		this.produto = produto;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumEntrada() {
		return numEntrada;
	}

	public void setNumEntrada(int numEntrada) {
		this.numEntrada = numEntrada;
	}

	public LocalDateTime getDtaAdmissao() {
		return dtaAdmissao;
	}

	public void setDtaAdmissao(LocalDateTime dtaAdmissao) {
		this.dtaAdmissao = dtaAdmissao;
	}
    
	public String getIndEntSaid() {
		return indEntSaid;
	}

	public void setIndEntSaid(String indEntSaid) {
		this.indEntSaid = indEntSaid;
	}
	
	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getValUnitario() {
		return valUnitario;
	}

	public void setValUnitario(double valUnitario) {
		this.valUnitario = valUnitario;
	}

	public double getValTotal() {
		return valTotal;
	}

	public void setValTotal(double valTotal) {
		this.valTotal = valTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
