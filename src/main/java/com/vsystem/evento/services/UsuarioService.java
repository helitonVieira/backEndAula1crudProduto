package com.vsystem.evento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsystem.evento.model.Usuario;
import com.vsystem.evento.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo ; 
	
	public UsuarioService() {}

	public UsuarioService(UsuarioRepository repo) {
		super();
		this.repo = repo;
	}
	
	public void salveUsuario(Usuario user) {
		repo.save(user);		
	}
	
	public Iterable<Usuario> showAllUsers(){
		return repo.findAll();
	}
	
	public Iterable<Usuario> deleteUserByNome(String nome){
		 repo.deleteByNome(nome);
		 return repo.findAll();
	}
	
	public Usuario findByNome(String nome){
		return repo.findByNome(nome);
	}
}
