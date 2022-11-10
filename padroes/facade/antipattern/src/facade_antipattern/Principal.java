package facade_antipattern;

public class Principal {
	public static void main(String[] args) {
		Carro carro = new Carro();
		
		InjecaoEletronica eletronica = new InjecaoEletronica();
		Motor motor = new Motor();
		Farol farol = new Farol();
		
		carro.setEletronica(eletronica);
		carro.setFarol(farol);
		carro.setMotor(motor);
		
		carro.getMotor().iniciarMotor();
		carro.getEletronica().iniciarInjecao();
		carro.getFarol().iniciarFarol();
	}
}
