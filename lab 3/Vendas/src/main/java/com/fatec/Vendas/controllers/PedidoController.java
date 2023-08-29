package com.fatec.Vendas.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.Vendas.models.Cliente;
import com.fatec.Vendas.models.Pedido;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins="*")
public class PedidoController {
	
	public PedidoController() {

		Pedido.addPedido(new Pedido(1,1,230.5,1)); 
		Pedido.addPedido(new Pedido(1,1,230.5,1)); 
		Pedido.addPedido(new Pedido(1,1,230.5,1)); 


	}
	
	@GetMapping
	Iterable<Pedido> getPedidos() {
		return Pedido.pedidos;
	}
	
	@PostMapping
	Pedido postCarro(@RequestBody Pedido pedido) {
		
		return Pedido.addPedido(pedido);
	}
}
