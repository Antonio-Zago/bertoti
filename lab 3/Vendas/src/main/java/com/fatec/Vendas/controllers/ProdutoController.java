package com.fatec.Vendas.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.Vendas.models.Pedido;
import com.fatec.Vendas.models.Produto;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins="*")
public class ProdutoController {
	
	public ProdutoController() {

		Produto.addProduto(new Produto("Café",10.0,1)); 
		Produto.addProduto(new Produto("Arroz",20.0,1)); 
		Produto.addProduto(new Produto("Feijão",30.0,1)); 


	}
	
	@GetMapping
	Iterable<Produto> getProdutos() {
		return Produto.produtos;
	}
	
	@PostMapping
	Produto postProduto(@RequestBody Produto produto) {
		
		return Produto.addProduto(produto);
	}
}
