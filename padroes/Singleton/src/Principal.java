
public class Principal {
	public static void main(String[] args) {
		
		
		
		Usuario usuario = new Usuario();
		usuario.setEmail("antonio@gmail.com");
		usuario.setSenha("1234");
		
		
		Login login = Login.getInstance(usuario);
		
		
	}
}
