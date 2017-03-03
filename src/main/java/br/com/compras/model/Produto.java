package br.com.compras.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private Long id;
	
	@Column(name = "nome", length = 45, nullable = false)
	private String nome;
		
	@Column(name = "preco", nullable = true)
	private BigDecimal preco;
		
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "id_img")
	private String img;
	
	public Produto(){}
	
	public Produto(String nome, BigDecimal preco, String descricao, String img) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.img = img;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
		
}
