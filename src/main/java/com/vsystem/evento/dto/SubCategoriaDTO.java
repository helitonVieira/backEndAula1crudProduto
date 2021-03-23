package com.vsystem.evento.dto;

import java.io.Serializable;

import com.vsystem.evento.model.SubCategoria;


public class SubCategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	//@NotEmpty(message="Preenchimento obrigatório")
	//@Length(min=2, max=80, message="O tamanho deve ser entre 2 e 80 caracteres")	
	private String descricao;

	public SubCategoriaDTO() {
	}
	
	public SubCategoriaDTO(SubCategoria obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

}
