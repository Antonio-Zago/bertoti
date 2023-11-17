package com.fatec.Vendas.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Fornecedor {
	
	public static List<Fornecedor> fornecedores = new ArrayList<>();
	public static Integer idIncremento = 0;
	
	public static Fornecedor addFornecedor(Fornecedor fornecedor) {
		fornecedor.id = idIncremento;
		idIncremento++;
		fornecedores.add(fornecedor);
		return fornecedor;
	}
	
	public static Fornecedor encontrarPorId(int idProcurado) {
        for (Fornecedor objeto : fornecedores) {
            if (objeto.getId() == idProcurado) {
                return objeto;
            }
        }
        return null;
	}
	
	public static Fornecedor atualizar(int idProcurado, Fornecedor clienteForm) {
		Fornecedor cliente = Fornecedor.encontrarPorId(idProcurado);
		
		cliente.setNome(clienteForm.getNome());
		cliente.setCnpj(clienteForm.getCnpj());
		
		return cliente;
		
	}
	
	public static void deletar(Integer id) {
		Iterator<Fornecedor> iterator = fornecedores.iterator();
        while (iterator.hasNext()) {
        	Fornecedor objeto = iterator.next();
            if (objeto.getId() == id) {
                iterator.remove();
            }
        }
		
	}

	
	public Fornecedor(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public Fornecedor() {}
	
	private Integer id;
	
	private String nome;
	
	private String cnpj;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
