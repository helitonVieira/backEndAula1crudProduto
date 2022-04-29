package com.vsystem.evento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsystem.evento.model.Products;
import com.vsystem.evento.repository.ProductsRepository;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository repo ; 
	
	public ProductsService() {}

	public ProductsService(ProductsRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Products salveProduto(Products produto) throws ObjectNotFoundException{
		//produto.setId(null);
		return repo.save(produto);
		 
	}
	
		
	public Products update(Products produto) throws ObjectNotFoundException {
		find(produto.getId());
		return repo.save(produto);		
	}
	
	public Iterable<Products> showAllProduto(){
		return repo.findAll();
	}
	
	public Products deleteProdutoById(int id) throws ObjectNotFoundException{
		find(id);
		return repo.deleteById(id);
		 
	}
	
	public Products find(int id) throws ObjectNotFoundException{
		Products obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id 
			          + "produto: " + Products.class.getName());
		}
		return obj;
	}
	
		
}
