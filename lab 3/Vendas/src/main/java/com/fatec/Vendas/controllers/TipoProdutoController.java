package com.fatec.Vendas.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.Vendas.models.Produto;
import com.fatec.Vendas.models.TipoProduto;

@RestController
@RequestMapping("/tipoProdutos")
@CrossOrigin(origins="*")
public class TipoProdutoController {
	
	public TipoProdutoController() {

		TipoProduto.addTipoProduto(new TipoProduto("Alimenticios")); 
		TipoProduto.addTipoProduto(new TipoProduto("Limpeza")); 
		TipoProduto.addTipoProduto(new TipoProduto("Tecnologia")); 


	}
	
	@GetMapping
	Iterable<TipoProduto> getTipoProdutos() {
		return TipoProduto.tiposProdutos;
	}
	
	@PostMapping
	TipoProduto postTipoProduto(@RequestBody TipoProduto tipoProduto) {
		
		return TipoProduto.addTipoProduto(tipoProduto);
	}
}
