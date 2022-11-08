package computador;

public class Computador {
	private Processador processador = null;
	private Memoria memoria = null;
	   
	public Computador(Processador processador,Memoria memoria ) {
		this.processador = processador;
		this.memoria = memoria;
	}
	
	public void ligarComputador() {
	      processador.start();
	      memoria.load();
	      processador.execute();
	      memoria.free();
	   }
}
