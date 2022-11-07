package composite_antipattern;

import java.util.ArrayList;
import java.util.List;

public class Tela {
	List<Botao> botaos;
	
	List<Label> labels;
	
	List<Text> texts;
	
	public Tela() {
		botaos = new ArrayList<>();
		labels = new ArrayList<>();
		texts = new ArrayList<>();
	}
	
	public void addBotao(Botao botao) {
		botaos.add(botao);
	}
	
	public void addLabel(Label label) {
		labels.add(label);
	}
	
	public void addText(Text text) {
		texts.add(text);
	}
	
}
