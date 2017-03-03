package br.com.compras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.compras.model.Produto;
import br.com.compras.repository.ProdutoRepository;

@Controller
@RequestMapping(value = "/rest")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Transactional
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public @ResponseBody Produto salvar(@RequestBody Produto produto) {
		try{
			return produtoRepo.save(produto);
			
		}catch(Exception e){
			return null;
		}
	}
	
	@Transactional
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> remove(@RequestBody Long id) {
		try{
			produtoRepo.delete(id);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}catch(Exception e){
			return null;
		}
	}
	@RequestMapping(value="/getById", method=RequestMethod.GET)
	public @ResponseBody Produto buscarId(Long id){
		return produtoRepo.findById(id);
	}
	
	@RequestMapping(value="/getByName", method=RequestMethod.GET)
	public @ResponseBody Produto buscarNome(String nome){
		return produtoRepo.findByNome(nome);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getAll(){
		 return new ResponseEntity<List<Produto>>((List<Produto>) produtoRepo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getByNames", method=RequestMethod.GET)
	public @ResponseBody List<Produto> buscarNomes(String nome){
		return produtoRepo.listaProdutosNome(nome);
	}
	
	@RequestMapping(value="/getByIds", method=RequestMethod.GET)
	public @ResponseBody List<Produto> buscarListaId(Long id){
		return produtoRepo.findProdutoById(id);
	}
	

	public void setProdutoRepo(ProdutoRepository produtoRepo) {
		this.produtoRepo = produtoRepo;
	}

}
