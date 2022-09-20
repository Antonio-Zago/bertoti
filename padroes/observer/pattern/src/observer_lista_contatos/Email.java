package observer_lista_contatos;

public class Email implements Observer{

	public void enviarMensagem(String texto) {
		
		System.out.println("Email: " + texto);
	}

}
