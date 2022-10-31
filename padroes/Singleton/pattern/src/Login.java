import java.util.List;

public class Login {
	
	
	
	private Usuario usuario;
	
	private static Login instance;
	
	private Login(Usuario usuario) {
		this.usuario = usuario;
		
	}
	
	public static Login getInstance(Usuario usuario) {
		if(Login.instance == null) {
			Login.instance = new Login(usuario);
		}
		
		return Login.instance;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}


	
	

}
