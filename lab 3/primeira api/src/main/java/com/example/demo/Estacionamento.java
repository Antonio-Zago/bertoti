package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;


public class Estacionamento {
	private List<Carro> carros = new ArrayList<>();
	
	public Estacionamento(){
		carros.addAll(List.of(
				new Carro("ABC", new Especificacao("GM", "Celta", "Vermelho")),
				new Carro("CBA", new Especificacao("Volks", "Polo", "Prata")),
				new Carro("GAF", new Especificacao("Ford", "Ford Ka", "Pretp"))
				));
	}
	
	public List<Carro> getCarros() {
		return this.carros;
	}
	
	public Optional<Carro> getCarrosByEspecificacao(String marca, String modelo, String cor){
		for (Carro c: this.carros) {
			if (c.getEspec().getMarca().equals(marca) || c.getEspec().getModelo().equals(modelo) || c.getEspec().getCor().equals(cor)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}
	
	public Carro addCarro(Carro carro) {
		this.carros.add(carro);
		return carro;
	}
}
