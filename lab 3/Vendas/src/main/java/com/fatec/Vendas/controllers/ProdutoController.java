package com.fatec.Vendas.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.Vendas.models.Cliente;
import com.fatec.Vendas.models.Pedido;
import com.fatec.Vendas.models.Produto;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins="*")
public class ProdutoController {
	
	public ProdutoController() {

		Produto.addProduto(new Produto("Café",10.0)); 
		Produto.addProduto(new Produto("Arroz",20.0)); 
		Produto.addProduto(new Produto("Feijão",30.0)); 


	}
	
	@GetMapping
	Iterable<Produto> getProdutos() {
		return Produto.produtos;
	}
	
	@PostMapping
	Produto postProduto(@RequestBody Produto produto) {
		
		return Produto.addProduto(produto);
	}
	
	@PutMapping("/{id}")
	Produto putCliente(@RequestBody Produto produto, @PathVariable Integer id) {
		
		
		
		return Produto.atualizar(id,produto);
	}
	
	@DeleteMapping("/{id}")
	void deleteCliente(@PathVariable Integer id) {
		
		
		
		Produto.deletar(id);
	}
}
