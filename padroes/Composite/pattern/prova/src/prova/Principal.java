package prova;

public class Principal {
	public static void main(String[] args) {
		BlocoPerguntas bloco = new BlocoPerguntas();
		Pergunta pergunta1 = new Pergunta();
		Pergunta pergunta2 = new Pergunta();
		Pergunta pergunta3 = new Pergunta();
		
		BlocoPerguntas bloco2 = new BlocoPerguntas();
		bloco2.addElemento(pergunta2);
		
		pergunta1.setDescricao("Pergunta1");
		pergunta2.setDescricao("Pergunta2");
		pergunta3.setDescricao("Pergunta3");
		
		bloco.addElemento(pergunta1);
		bloco.addElemento(pergunta2);
		bloco.addElemento(pergunta3);
		bloco.addElemento(bloco2);
		
		bloco.mostrarDescricao();
		
		
	}
}
