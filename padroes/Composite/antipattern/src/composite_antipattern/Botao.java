package composite_antipattern;

public class Botao {
	private String nome;
	
	
	public void onClick() {
		System.out.println("Evento click do botão");
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
