package observer_lista_contatos;

import java.util.ArrayList;

public class Contatos implements Observable {
	
	private ArrayList observers;
	
	public Contatos() {
		observers = new ArrayList<>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}


	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
		
	}

	public void notifyObservers(String texto) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.enviarMensagem(texto);
		}
		
	}
	
	public String envio(String texto){
		
		
		notifyObservers(texto);
		return texto;
		
	}
	
}
