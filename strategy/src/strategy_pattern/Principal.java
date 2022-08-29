package strategy_pattern;

public class Principal {
	
public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		
		cliente.setDesconto(new DescontoAniversario());
		
		
		Cliente cliente2 = new Cliente();
		
		cliente2.setDesconto(new DescontoNatal());
		
		
		
		System.out.println("Cliente 1 valor total: " + cliente.aplicarDesconto(100));
		
		System.out.println("Cliente 2 valor total: " + cliente2.aplicarDesconto(100));
		
		
		
	}
}
