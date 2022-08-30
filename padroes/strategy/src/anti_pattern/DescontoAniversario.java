package anti_pattern;

public class DescontoAniversario extends Desconto{
	@Override
	public double aplicarDesconto(double valor) {
		return valor -(valor * 50/100);
	}
}
