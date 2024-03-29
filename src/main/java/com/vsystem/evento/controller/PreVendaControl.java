package com.vsystem.evento.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vsystem.evento.dto.PreVendaDTO;
import com.vsystem.evento.model.PreVenda;
import com.vsystem.evento.services.PreVendaService;


@RestController
@RequestMapping(value="/prevendas")
public class PreVendaControl {
	
	@Autowired
	private PreVendaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PreVenda> find(@PathVariable Integer id) {
		PreVenda obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(//@Valid 
			@RequestBody PreVendaDTO objDto) {
		PreVenda obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(//@Valid 
			@RequestBody PreVendaDTO objDto, @PathVariable Integer id) {
		PreVenda obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PreVendaDTO>> findAll() {
		List<PreVenda> list = service.findAll();
		List<PreVendaDTO> listDto = list.stream().map(obj -> new PreVendaDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PreVendaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="2") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {//DESC
		Page<PreVenda> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PreVendaDTO> listDto = list.map(obj -> new PreVendaDTO(obj)); //convert p dto 
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/preVenda")
	public Iterable<PreVenda> showAllSubcategorias(){
		return service.showAllSubcategorias();
	}

}
