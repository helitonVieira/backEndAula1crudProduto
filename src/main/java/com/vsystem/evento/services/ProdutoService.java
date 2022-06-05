package com.vsystem.evento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vsystem.evento.dto.ProdutoDTO;
import com.vsystem.evento.model.Produto;
import com.vsystem.evento.model.SubCategoria;
import com.vsystem.evento.repository.ProdutoRepository;
import com.vsystem.evento.services.exception.DataIntegrityException;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo ; 
	
	/*@Autowired
	private EmailService emailService;*/
	
	public ProdutoService() {}

	public ProdutoService(ProdutoRepository repo) {
		super();
		this.repo = repo;
	}
	
	public void salveProduto(Produto produto) {
		repo.save(produto);	
		//envio por smtp
		//emailService.sendOrderConfirmationEmail(produto);
		
		//envio por html caso de erro envia via smtp
		//emailService.sendOrderConfirmationHtmlEmail(produto);
	}
	
	public Produto update(Produto produto) throws ObjectNotFoundException {
		find(produto.getId());
		return repo.save(produto);		
	}
	
	public Iterable<Produto> showAllProduto(){
		return repo.findAll();
	}
	
	
	public void deleteProdutoById(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este produto!");
		}
	}
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	} //import org.springframework.data.domain.Sort.Direction;
	
	public Produto fromDTO(ProdutoDTO produtoDTO, SubCategoria subCat) {
		return new Produto(produtoDTO.getId(),produtoDTO.getNome(),subCat,produtoDTO.getPreco());	 		
	}
		
}
