package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


public class Cliente {
	
	public static List<Cliente> clientes = new ArrayList<>();
	public static Integer idIncremento = 0;
	
	public static Cliente addCliente(Cliente cliente) {
		cliente.id = idIncremento;
		idIncremento++;
		clientes.add(cliente);
		return cliente;
	}

	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Cliente() {}
	
	
	private Integer id;
	
	private String nome;
	
	private String cpf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
