package computador;

public class Principal {
	public static void main(String[] args) {
		Processador processador = new Processador();
		Memoria memoria = new Memoria();
		Computador computador = new Computador(processador, memoria);
		
		computador.ligarComputador();
	}
}
