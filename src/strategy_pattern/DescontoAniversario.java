package strategy_pattern;

public class DescontoAniversario implements Desconto{


	public double aplicarDesconto(double valor) {
		return valor - ((valor) * 20/100);
	}

}
