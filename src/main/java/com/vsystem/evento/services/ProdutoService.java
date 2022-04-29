package com.vsystem.evento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsystem.evento.dto.ProdutoDTO;
import com.vsystem.evento.model.Produto;
import com.vsystem.evento.model.SubCategoria;
import com.vsystem.evento.repository.ProdutoRepository;
import com.vsystem.evento.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo ; 
	
	@Autowired
	private EmailService emailService;
	
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
	
	public Produto deleteProdutoById(int id) throws ObjectNotFoundException{
		find(id);
		return repo.deleteById(id);
		 
	}
	
	public Produto find(int id) throws ObjectNotFoundException{
		Produto obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id 
			          + "produto: " + Produto.class.getName());
		}
		return obj;
	}
	
	public Produto fromDTO(ProdutoDTO produtoDTO, SubCategoria subCat) {
		return new Produto(produtoDTO.getId(),produtoDTO.getNome(),subCat,produtoDTO.getPreco());	 		
	}
		
}
