package br.com.compras.repository;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.compras.model.Produto;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class ProdutoRepositoryTest extends TestCase{
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	private ArrayList<Produto> list;
	
	@Test
	public void testFindAll() throws Exception{
		list = (ArrayList<Produto>) produtoRepo.findAll();
		Produto p = (Produto) list.get(0);
		Assert.assertEquals("armario", p.getNome());
	}
	@Test
	public void testGetById() throws Exception{
		Assert.assertEquals("televisao", produtoRepo.findById(3L).getNome());
	}
	@Test
	public void testGetByName() throws Exception{
		Assert.assertEquals("armario", produtoRepo.findByNome("armario").getNome());
	}
	@Test
	public void testGetByNames() throws Exception{
		list = (ArrayList<Produto>) produtoRepo.listaProdutosNome("mesa");
		Produto p = (Produto) list.get(0);
		Assert.assertEquals("mesa", p.getNome());
	}
	@Test
	public void testGetByIds() throws Exception{
		list = (ArrayList<Produto>) produtoRepo.findProdutoById(2l);
		Produto p = (Produto) list.get(0);
		Assert.assertEquals("mesa", p.getNome());
	}
	
	@Test
	public void testSave() throws Exception{
		Produto p = new Produto("violao", new BigDecimal(599.9), "Violao Dallas", "violao");
		Integer antes = (int) produtoRepo.count();
		produtoRepo.save(produtoRepo.save(p));
		assertEquals(antes + 1, produtoRepo.count());
		Assert.assertEquals("violao", p.getNome().toString());
	}

	@Test
	public void testDelete() throws Exception{
		Produto p = produtoRepo.findByNome("violao");
		Integer antes = (int) produtoRepo.count();
		produtoRepo.delete(p.getId());
		assertEquals(antes - 1, produtoRepo.count());
	}
	
	public void setProdutoRepo(ProdutoRepository produtoRepo) {
		this.produtoRepo = produtoRepo;
	}
	

}
