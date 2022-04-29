package com.vsystem.evento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vsystem.evento.dto.SubCategoriaDTO;
import com.vsystem.evento.model.SubCategoria;
import com.vsystem.evento.repository.SubCategoriaRepository;
import com.vsystem.evento.services.exception.DataIntegrityException;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@Service
public class SubCategoriaService {
	@Autowired
	private SubCategoriaRepository repo;

	public SubCategoria find(Integer id) {
		Optional<SubCategoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + SubCategoria.class.getName()));
	}

	public SubCategoria insert(SubCategoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public SubCategoria update(SubCategoria obj) {
		SubCategoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma subCategoria que possui produtos");
		}
	}

	public List<SubCategoria> findAll() {
		return repo.findAll();
	}

	public Page<SubCategoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	} //import org.springframework.data.domain.Sort.Direction;

	public SubCategoria fromDTO(SubCategoriaDTO objDto) {
		return new SubCategoria(objDto.getId(), objDto.getDescricao());
	}

	private void updateData(SubCategoria newObj, SubCategoria obj) {
		newObj.setDescricao(obj.getDescricao());
	}
	
	public Iterable<SubCategoria> showAllSubcategorias(){
		return repo.findAll();
	}
}
