package observer_lista_contatos;

public class Celular implements Observer{

	public void enviarMensagem(String texto) {
		System.out.println("Celular: " + texto);
		
	}

}
