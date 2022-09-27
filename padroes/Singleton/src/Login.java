import java.util.List;

public class Login {
	
	private static List<Usuario> listaDeUsuarios;
	
	private String userName;
	
	private Usuario usuario;
	private static Login instance;
	
	private Login(Usuario usuario) {
		this.usuario = usuario;
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setEmail("antonio@gmail.com");
		usuario2.setSenha("1234");
		
		listaDeUsuarios.add(usuario2);
	}
	
	public static Login getInstance(Usuario usuario) {
		if(Login.instance == null) {
			Login.instance = new Login(usuario);
		}
		
		return Login.instance;
	} 

}
