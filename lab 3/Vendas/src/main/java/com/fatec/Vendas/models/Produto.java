package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public static Produto encontrarPorId(int idProcurado) {
        for (Produto objeto : produtos) {
            if (objeto.getId() == idProcurado) {
                return objeto;
            }
        }
        return null;
	}
	

	
	public static Produto atualizar(int idProcurado, Produto clienteForm) {
		Produto cliente = Produto.encontrarPorId(idProcurado);
		
		cliente.setNome(clienteForm.getNome());
		cliente.setValor(clienteForm.getValor());
		
		return cliente;
		
	}
	
	public static void deletar(Integer id) {
		Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto objeto = iterator.next();
            if (objeto.getId() == id) {
                iterator.remove();
            }
        }
		
	}

	
	public Produto(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public Produto() {}
	
	
	private Integer id;
	
	private String nome;
	
	private Double valor;


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


	
	
	
	
}
