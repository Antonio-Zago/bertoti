package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.List;

import com.fatec.Vendas.dto.PedidoForm;

public class Pedido {
	
	public static List<Pedido> pedidos = new ArrayList<>();
	public static Integer idIncremento = 0;
	
	public static Pedido addPedido(Pedido pedido) {
		pedido.id = idIncremento;
		idIncremento++;
		pedidos.add(pedido);
		return pedido;
	}
	
	public static Pedido addPedidoDto(PedidoForm dto) {
		Pedido pedido = new Pedido();
		List<Integer> produtos = new ArrayList<Integer>();
		produtos.add(dto.getIdProduto());

		
		pedido.setIdCliente(dto.getIdCliente());
		pedido.setIdFornecedor(dto.getIdFornecedor());
		pedido.setProdutos(produtos );
		pedido.setValorPedido(Produto.encontrarPorId(dto.getIdProduto()).getValor());
		
		pedido.id = idIncremento;
		idIncremento++;
		pedidos.add(pedido);
		return pedido;
	}

	
	public Pedido(Integer idCliente, List<Integer> produtos, Double valorPedido, Integer idFornecedor) {
		this.idCliente = idCliente;
		this.produtos = produtos;
		this.valorPedido = valorPedido;
		this.idFornecedor = idFornecedor;
	}
	
	public Pedido() {}
	
	
	private Integer id;
	
	private Integer idCliente;
	
	private List<Integer> produtos;
	
	private Double valorPedido;
	
	private Integer idFornecedor;

	
	
	
	public List<Integer> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Integer> produtos) {
		this.produtos = produtos;
	}


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
