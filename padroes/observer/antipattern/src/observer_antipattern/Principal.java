package observer_antipattern;

public class Principal {
	public static void main(String[] args) {
		
		TelaCelular celular = new TelaCelular();
		TelaComputador computador = new TelaComputador();
		TelaTelevisao televisao = new TelaTelevisao();
		
		celular.MostrarTexto("Texto qualquer celular");
		computador.MostrarTexto("Texto qualquer computador");
		televisao.MostrarTexto("Texto qualquer televisão");
		
	}
}
