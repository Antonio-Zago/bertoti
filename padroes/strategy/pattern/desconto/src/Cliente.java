

public class Cliente {
	private Desconto desconto;


	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}
	
	public double aplicarDesconto(double valor) {
		return this.desconto.aplicarDesconto(valor);
	} 
	
}
