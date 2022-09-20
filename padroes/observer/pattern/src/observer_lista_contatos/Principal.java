package observer_lista_contatos;

public class Principal {
	public static void main(String[] args) {
		Contatos contatos = new Contatos();
		
		Email email = new Email();
		Celular celular = new Celular();
		
		contatos.registerObserver(email);
		contatos.registerObserver(celular);
		
		contatos.envio("Email qualquer para todos os notificados");
	}
}
