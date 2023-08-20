package com.example.demo;

public class Especificacao {
	private String marca;
	
	private String modelo;
	
	private String cor;
	
	public Especificacao(String marca, String modelo, String cor) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}		
