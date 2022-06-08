package com.vsystem.evento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vsystem.evento.dto.PreVendaDTO;
import com.vsystem.evento.model.PreVenda;
import com.vsystem.evento.repository.PreVendaRepository;
import com.vsystem.evento.services.exception.DataIntegrityException;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@Service
public class PreVendaService {
	@Autowired
	private PreVendaRepository repo;

	public PreVenda find(Integer id) {
		Optional<PreVenda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PreVenda.class.getName()));
	}

	public PreVenda insert(PreVenda obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public PreVenda update(PreVenda preVenda) throws ObjectNotFoundException {
		find(preVenda.getId());
		return repo.save(preVenda);		
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma preVenda que possui produtos");
		}
	}

	public List<PreVenda> findAll() {
		return repo.findAll();
	}

	public Page<PreVenda> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	} //import org.springframework.data.domain.Sort.Direction;

	public PreVenda fromDTO(PreVendaDTO objDto) {
		return new PreVenda(objDto.getId(), 
				            objDto.getDtaPreVenda(),
				            objDto.getDtaValidade(),
				            objDto.getStatus(),
				            objDto.getCliente());
	}

	
	/*private void updateStatus(PreVenda newObj, PreVenda obj) {
		newObj.setStatus(obj.getStatus());
	}*/
	
	public Iterable<PreVenda> showAllSubcategorias(){
		return repo.findAll();
	}
}
