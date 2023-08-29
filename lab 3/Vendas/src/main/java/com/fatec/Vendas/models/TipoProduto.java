package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.List;

public class TipoProduto {
	
	public static List<TipoProduto> tiposProdutos = new ArrayList<>();
	public static Integer idIncremento = 0;
	
	public static TipoProduto addTipoProduto(TipoProduto tipoProduto) {
		tipoProduto.id = idIncremento;
		idIncremento++;
		tiposProdutos.add(tipoProduto);
		return tipoProduto;
	}

	
	public TipoProduto(String nome) {
		this.nome = nome;
	}
	
	public TipoProduto() {}
	
	private Integer id;
	
	private String nome;

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
	
	
}
