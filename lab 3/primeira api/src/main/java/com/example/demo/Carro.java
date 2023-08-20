package com.example.demo;

public class Carro {
	private String placa;
	private Especificacao espec;
	
	public Carro(String placa, Especificacao espec) {
		this.placa = placa;
		this.espec = espec;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Especificacao getEspec() {
		return espec;
	}
	public void setEspec(Especificacao espec) {
		this.espec = espec;
	}
	
	
	
}
