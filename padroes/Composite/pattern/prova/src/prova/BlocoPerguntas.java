package prova;
import java.util.ArrayList;
import java.util.List;

public class BlocoPerguntas implements ElementoBasico{

	private List<ElementoBasico> lista;
	
	
	public BlocoPerguntas() {
		this.lista = new ArrayList<>();
	}
	public void mostrarDescricao() {
		for (ElementoBasico elementoBasico : lista) {
			elementoBasico.mostrarDescricao();
		}
		
	}
	
	public void addElemento(ElementoBasico elementoBasico) {
		lista.add(elementoBasico);
    }

    public void removeElemento(ElementoBasico elementoBasico) {
    	lista.remove(elementoBasico);
    }

}
