package com.vsystem.evento.repository;

import org.springframework.data.repository.CrudRepository;

import com.vsystem.evento.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer > {
	
	public Iterable<Usuario> deleteByNome(String nome);
	public Usuario findByNome(String nome);
}
