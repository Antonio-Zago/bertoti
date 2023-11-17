package com.fatec.Vendas.dto;

import java.util.List;

public class PedidoDto {
	private Integer id;
	
	private String nomeCliente;
	
	private List<String> nomeProdutos;
	
	private Double valorPedido;
	
	private String nomeFornecedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public List<String> getNomeProdutos() {
		return nomeProdutos;
	}

	public void setNomeProdutos(List<String> nomeProdutos) {
		this.nomeProdutos = nomeProdutos;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	
}
