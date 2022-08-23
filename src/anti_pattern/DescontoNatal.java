package anti_pattern;

public class DescontoNatal extends Desconto{
	
	
	
	@Override
	public double aplicarDesconto(double valor) {
		return valor -(valor * 20/100);
	}
	
}
