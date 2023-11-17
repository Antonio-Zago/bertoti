package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.Iterator;
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

	public static Cliente encontrarPorId(int idProcurado) {
        for (Cliente objeto : clientes) {
            if (objeto.getId() == idProcurado) {
                return objeto;
            }
        }
        return null;
	}
	
	public static Cliente atualizar(int idProcurado, Cliente clienteForm) {
		Cliente cliente = Cliente.encontrarPorId(idProcurado);
		
		cliente.setNome(clienteForm.getNome());
		cliente.setCpf(clienteForm.getCpf());
		
		return cliente;
		
	}
	
	public static void deletar(Integer id) {
		Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente objeto = iterator.next();
            if (objeto.getId() == id) {
                iterator.remove();
            }
        }
		
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
