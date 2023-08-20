package com.example.demo;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/carros")
@CrossOrigin(origins="*")
public class CarroController {
	
	public Estacionamento estacionamento;
	
	public CarroController() {
		this.estacionamento = new Estacionamento();
	}
	
	@GetMapping
	Iterable<Carro> getCarros() {
		return estacionamento.getCarros();
	}
	
	@GetMapping("/{marca}/{modelo}/{cor}")
	Optional<Carro> getCarroByEspecificacao(@PathVariable String marca, @PathVariable String modelo, @PathVariable String cor) {
		return estacionamento.getCarrosByEspecificacao(marca, modelo, cor);
	}
	
	@PostMapping
	Carro postCarro(@RequestBody Carro carro) {
		
		return estacionamento.addCarro(carro);
	}

	
}
