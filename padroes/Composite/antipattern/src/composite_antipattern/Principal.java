package composite_antipattern;

public class Principal {
	public static void main(String[] args) {
		Tela tela = new Tela();
		
		Botao botao = new Botao();
		Label label = new Label();
		Text text = new Text();
		
		tela.addBotao(botao);
		tela.addLabel(label);
		tela.addText(text);
	}
}
