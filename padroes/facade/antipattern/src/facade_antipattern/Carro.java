package facade_antipattern;

public class Carro {
	
	private Farol farol;
	
	private Motor motor;
	
	private InjecaoEletronica eletronica;

	public Farol getFarol() {
		return farol;
	}

	public void setFarol(Farol farol) {
		this.farol = farol;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public InjecaoEletronica getEletronica() {
		return eletronica;
	}

	public void setEletronica(InjecaoEletronica eletronica) {
		this.eletronica = eletronica;
	}
	
	
	
	 
}
