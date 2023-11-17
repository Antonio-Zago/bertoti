package com.fatec.Vendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
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

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins="*")
public class ClienteController {

	
	public ClienteController() {

		Cliente.addCliente(new Cliente("Antonio", "123456")); 
		Cliente.addCliente(new Cliente("Roberto", "543535")); 
		Cliente.addCliente(new Cliente("Almeida", "4656456")); 


	}
	
	@GetMapping
	Iterable<Cliente> getClientes() {
		return Cliente.clientes;
	}
	
	@PostMapping
	Cliente postCliente(@RequestBody Cliente cliente) {
		
		return Cliente.addCliente(cliente);
	}
	
	@PutMapping("/{id}")
	Cliente putCliente(@RequestBody Cliente clienteForm, @PathVariable Integer id) {
		
		
		
		return Cliente.atualizar(id,clienteForm);
	}
	
	@DeleteMapping("/{id}")
	void deleteCliente(@PathVariable Integer id) {
		
		
		
		Cliente.deletar(id);
	}

}
