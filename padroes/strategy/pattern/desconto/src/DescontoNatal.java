

public class DescontoNatal  implements Desconto{


	public double aplicarDesconto(double valor) {
		return valor - ((valor) * 10/100);
	}
	
}
