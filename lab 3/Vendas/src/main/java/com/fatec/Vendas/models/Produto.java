package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	
	public static List<Produto> produtos = new ArrayList<>();
	public static Integer idIncremento = 0;
	
	public static Produto addProduto(Produto produto) {
		produto.id = idIncremento;
		idIncremento++;
		produtos.add(produto);
		return produto;
	}

	
	public Produto(String nome, Double valor, Integer idTipoProduto) {
		this.nome = nome;
		this.valor = valor;
		this.idTipoProduto = idTipoProduto;
	}
	
	public Produto() {}
	
	
	private Integer id;
	
	private String nome;
	
	private Double valor;
	
	private Integer idTipoProduto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getIdTipoProduto() {
		return idTipoProduto;
	}

	public void setIdTipoProduto(Integer idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}

	
	
	
	
}
