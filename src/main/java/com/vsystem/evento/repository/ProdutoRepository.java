package com.vsystem.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsystem.evento.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer > {

	
}