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

import com.vsystem.evento.model.Produto;
import com.vsystem.evento.services.ProdutoService;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@RestController
public class ProdutoControl {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping("/produtos")
	@Transactional
	public Produto cadastraProduto(@RequestBody Produto produto) {		 
			service.salveProduto(produto);		
			return  produto;			
	}
	
	@GetMapping("/produtos")
	public Iterable<Produto> showAllProduto(){
		return service.showAllProduto();
	}
		
	@RequestMapping(value="/produtos/{id}", method= RequestMethod.DELETE)
	@Transactional
	public  ResponseEntity<Void> deleteProduto( @PathVariable int id) throws ObjectNotFoundException{
		  service.deleteProdutoById(id);
		return  ResponseEntity.noContent().build();
	}
	
	@GetMapping("/produtos/{id}")
	@Transactional
	public Produto buscaProduto(@PathVariable int id) throws ObjectNotFoundException{
		return service.find(id);
	}
	
	@RequestMapping(value="/produtos/{id}", method= RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> update(@RequestBody Produto obj, @PathVariable int id) throws ObjectNotFoundException{
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
