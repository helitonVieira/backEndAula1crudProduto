package com.vsystem.evento.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vsystem.evento.model.Cliente;
import com.vsystem.evento.model.PreVenda;

@Repository
public interface PreVendaRepository extends JpaRepository<PreVenda, Integer> {

	@Transactional(readOnly=true)
	Page<PreVenda> findByCliente(Cliente cliente, Pageable pageRequest);
}
