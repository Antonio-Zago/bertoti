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
import com.fatec.Vendas.models.Fornecedor;

@RestController
@RequestMapping("/fornecedores")
@CrossOrigin(origins="*")
public class FornecedorController {

	public FornecedorController() {

		Fornecedor.addFornecedor(new Fornecedor("LG", "123456")); 
		Fornecedor.addFornecedor(new Fornecedor("Samsung", "543535")); 
		Fornecedor.addFornecedor(new Fornecedor("Dell", "4656456")); 


	}
	
	@GetMapping
	Iterable<Fornecedor> getFornecedores() {
		return Fornecedor.fornecedores;
	}
	
	@PostMapping
	Fornecedor postFornecedor(@RequestBody Fornecedor fornecedor) {
		
		return Fornecedor.addFornecedor(fornecedor);
	}
	
	@PutMapping("/{id}")
	Fornecedor putCliente(@RequestBody Fornecedor clienteForm, @PathVariable Integer id) {
		
		
		
		return Fornecedor.atualizar(id,clienteForm);
	}
	
	@DeleteMapping("/{id}")
	void deleteCliente(@PathVariable Integer id) {
		
		
		
		Fornecedor.deletar(id);
	}
	
}
