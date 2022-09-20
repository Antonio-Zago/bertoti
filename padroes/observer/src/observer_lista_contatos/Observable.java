package observer_lista_contatos;

public interface Observable {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers(String texto);
}
