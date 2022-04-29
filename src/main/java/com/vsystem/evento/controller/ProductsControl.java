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

import com.vsystem.evento.model.Products;
import com.vsystem.evento.services.ProductsService;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@org.springframework.web.bind.annotation.RestController
public class ProductsControl {
	
	@Autowired
	private ProductsService service;
	
	@PostMapping("/products")
	@Transactional
	public Products cadastraProduto(@RequestBody Products produto) {		 
			service.salveProduto(produto);		
			return  produto;			
	}
	
	@GetMapping("/products")
	public Iterable<Products> showAllProduto(){
		return service.showAllProduto();
	}
	
	@GetMapping("/api/products")
	public Iterable<Products> showAllProduto2(){
		return service.showAllProduto();
	}
	
	@RequestMapping(value="/products/{id}", method= RequestMethod.DELETE)
	@Transactional
	public  ResponseEntity<Void> deleteProduto( @PathVariable int id) throws ObjectNotFoundException{
		  service.deleteProdutoById(id);
		return  ResponseEntity.noContent().build();
	}
	
	@GetMapping("/products/{id}")
	@Transactional
	public Products buscaProduto(@PathVariable int id) throws ObjectNotFoundException{
		return service.find(id);
	}
	
	@RequestMapping(value="/products/{id}", method= RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> update(@RequestBody Products obj, @PathVariable int id) throws ObjectNotFoundException{
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
