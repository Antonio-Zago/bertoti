package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	public static List<Pedido> pedidos = new ArrayList<>();
	public static Integer idIncremento = 0;
	
	public static Pedido addPedido(Pedido pedido) {
		pedido.id = idIncremento;
		idIncremento++;
		pedidos.add(pedido);
		return pedido;
	}

	
	public Pedido(Integer idCliente, Integer idProduto, Double valorPedido, Integer idFornecedor) {
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.valorPedido = valorPedido;
		this.idFornecedor = idFornecedor;
	}
	
	public Pedido() {}
	
	
	private Integer id;
	
	private Integer idCliente;
	
	private Integer idProduto;
	
	private Double valorPedido;
	
	private Integer idFornecedor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public Integer getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}


	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}


	public Integer getIdFornecedor() {
		return idFornecedor;
	}


	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	
	

}
