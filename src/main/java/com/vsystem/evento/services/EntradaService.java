package com.vsystem.evento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsystem.evento.model.Entrada;
import com.vsystem.evento.repository.EntradaRepository;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@Service
public class EntradaService {
	
	@Autowired
	private EntradaRepository repo ; 
	
	public EntradaService() {}

	public EntradaService(EntradaRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Entrada salveEntrada(Entrada entrada) throws ObjectNotFoundException{
		//entrada.setId(null);
		return repo.save(entrada);
		 
	}
	
		
	public Entrada update(Entrada entrada) throws ObjectNotFoundException {
		find(entrada.getId());
		return repo.save(entrada);		
	}
	
	public Iterable<Entrada> showAllEntrada(){
		return repo.findAll();
	}
	
	public Entrada deleteEntradaById(int id) throws ObjectNotFoundException{
		find(id);
		return repo.deleteById(id);
		 
	}
	
	public Entrada find(int id) throws ObjectNotFoundException{
		Entrada obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id 
			          + "entrada: " + Entrada.class.getName());
		}
		return obj;
	}
	

}
