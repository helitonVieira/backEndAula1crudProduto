package com.vsystem.evento.repository;

import org.springframework.data.repository.CrudRepository;

import com.vsystem.evento.model.Products;

public interface ProductsRepository extends CrudRepository<Products, Integer > {
	
	public Products deleteById(int id);
	public Products findById(int id);
}