package com.vsystem.evento.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vsystem.evento.model.Entrada;
import com.vsystem.evento.services.EntradaService;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@RestController
public class EntradaControl {
	
	@Autowired
	private EntradaService service;
	
	@PostMapping("/entradas")
	@Transactional
	public Entrada cadastraEntrada(@RequestBody Entrada entrada) {		 
			service.salveEntrada(entrada);		
			return  entrada;			
	}
	
	@GetMapping("/entradas")
	public Iterable<Entrada> showAllEntrada(){
		return service.showAllEntrada();
	}
	
	@GetMapping("/api/entradas")
	public Iterable<Entrada> showAllEntrada2(){
		return service.showAllEntrada();
	}
	
	@RequestMapping(value="/entradas/{id}", method= RequestMethod.DELETE)
	@Transactional
	public  ResponseEntity<Void> deleteEntrada( @PathVariable int id) throws ObjectNotFoundException{
		  service.deleteEntradaById(id);
		return  ResponseEntity.noContent().build();
	}
	
	@GetMapping("/entradas/{id}")
	@Transactional
	public Entrada buscaEntrada(@PathVariable int id) throws ObjectNotFoundException{
		return service.find(id);
	}
	
	@RequestMapping(value="/entradas/{id}", method= RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> update(@RequestBody Entrada obj, @PathVariable int id) throws ObjectNotFoundException{
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
