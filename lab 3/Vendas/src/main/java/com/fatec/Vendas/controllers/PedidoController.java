package com.fatec.Vendas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.Vendas.dto.PedidoDto;
import com.fatec.Vendas.models.Cliente;
import com.fatec.Vendas.models.Fornecedor;
import com.fatec.Vendas.models.Pedido;
import com.fatec.Vendas.models.Produto;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins="*")
public class PedidoController {
	
	public PedidoController() {
		List<Integer> pedidosId = new ArrayList<Integer>();
		pedidosId.add(1);
		pedidosId.add(2);
		Pedido.addPedido(new Pedido(1,pedidosId,230.5,1)); 
		Pedido.addPedido(new Pedido(1,pedidosId,230.5,1)); 
		Pedido.addPedido(new Pedido(1,pedidosId,230.5,1)); 


	}
	
	@GetMapping
	Iterable<PedidoDto> getPedidos() {
		
		List<Pedido> pedidos = Pedido.pedidos;
		List<String> nomeProdutos = new ArrayList<String>();
		List<PedidoDto> dtos = new ArrayList<PedidoDto>();
		
		
		for (Pedido pedido : pedidos) {
			Cliente cliente = Cliente.encontrarPorId(pedido.getIdCliente());
			Fornecedor fornecedor = Fornecedor.encontrarPorId(pedido.getIdFornecedor());
			for (Integer produtoId : pedido.getProdutos()) {
				Produto produto = Produto.encontrarPorId(produtoId);
				nomeProdutos.add(produto.getNome());
			}
			PedidoDto dto = new PedidoDto();
			dto.setId(pedido.getId());
			dto.setNomeCliente(cliente.getNome());
			dto.setNomeFornecedor(fornecedor.getNome());
			dto.setNomeProdutos(nomeProdutos);
			dto.setValorPedido(pedido.getValorPedido());
			dtos.add(dto);
		}
		
		
		return dtos;
	}
	
	@PostMapping
	Pedido postCarro(@RequestBody Pedido pedido) {
		
		return Pedido.addPedido(pedido);
	}
}
