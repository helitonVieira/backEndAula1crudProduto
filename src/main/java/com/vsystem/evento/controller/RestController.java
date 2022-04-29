package com.vsystem.evento.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vsystem.evento.model.Usuario;
import com.vsystem.evento.services.UsuarioService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/save-user")
	@Transactional
	public String cadastraUsuario(@RequestBody Usuario user) {		 
			service.salveUsuario(user);		
			return "Ola " + user.getNome() + " cadastro registrado com sucesso!";			
	}
	
	@GetMapping("/all-user")
	public Iterable<Usuario> showAllUsers(){
		return service.showAllUsers();
	}
	
	@GetMapping("/delete/{nome}")
	@Transactional
	public Iterable<Usuario> deleteUser(@PathVariable String nome){
		return service.deleteUserByNome(nome);
	}
	
	@GetMapping("/busca/{nome}")
	@Transactional
	public Usuario buscaUser(@PathVariable String nome){
		return service.findByNome(nome);
	}
	

}
