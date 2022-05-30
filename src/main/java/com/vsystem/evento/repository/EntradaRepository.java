package com.vsystem.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsystem.evento.model.Entrada;


@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer>  {
	public Entrada deleteById(int id);
	public Entrada findById(int id);
}
