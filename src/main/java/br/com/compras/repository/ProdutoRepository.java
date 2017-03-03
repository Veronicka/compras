package br.com.compras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.compras.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	public Produto findById(Long id);
	public Produto findByNome(String nome);
	public List<Produto> findProdutoById(Long id);
	
	@Query("select p from Produto p where p.nome like %?1%")
	public List<Produto> listaProdutosNome(String nome);
	
}
