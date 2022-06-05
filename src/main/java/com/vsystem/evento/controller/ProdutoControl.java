package com.vsystem.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vsystem.evento.model.Produto;
import com.vsystem.evento.services.ProdutoService;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoControl {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping("")
	@Transactional
	public Produto cadastraProduto(@RequestBody Produto produto) {		 
			service.salveProduto(produto);		
			return  produto;			
	}
	
	@GetMapping("")
	public Iterable<Produto> showAllProduto(){
		return service.showAllProduto();
	}
		
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@Transactional
	public  ResponseEntity<Void> deleteProduto( @PathVariable int id) throws ObjectNotFoundException{
		  service.deleteProdutoById(id);
		return  ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@Transactional
	public Produto buscaProduto(@PathVariable int id) throws ObjectNotFoundException{
		return service.find(id);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> update(@RequestBody Produto obj, @PathVariable int id) throws ObjectNotFoundException{
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Produto>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="2") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {//DESC
		Page<Produto> list = service.findPage(page, linesPerPage, orderBy, direction);
		//Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj)); //convert p dto 
		return ResponseEntity.ok().body(list);
	}

}
