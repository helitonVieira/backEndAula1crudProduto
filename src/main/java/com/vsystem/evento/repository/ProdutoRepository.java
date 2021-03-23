package com.vsystem.evento.repository;

import org.springframework.data.repository.CrudRepository;

import com.vsystem.evento.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer > {
	
	public Produto deleteById(int id);
	public Produto findById(int id);
}