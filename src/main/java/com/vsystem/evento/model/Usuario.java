package com.vsystem.evento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab_usuario")
public class Usuario {
	
	@Id
	@Column(name="cod_usuario")
	private int id;
	
	@Column(name="nom_usuario")
	private String nome;
	
	@Column(name="des_email")
	private String email;
	
	@Column(name="num_idade")
	private int idade;
	
	@Column(name="des_senha")
	private String senha;
	
	public Usuario() {}

	public Usuario(int id, String nome, String email, int idade, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
