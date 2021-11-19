package uy.com.bse.soluciones.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import uy.com.bse.soluciones.domain.Usuario;

@SessionScoped
public class UsuarioModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	@PostConstruct
	public void init() {
		Usuario u1 = new Usuario("usuario", "usuario");
		Usuario u2 = new Usuario("usuario1", "usuario1");
		Usuario u3 = new Usuario("usuario2", "usuario2");
		Usuario u4 = new Usuario("usuario3", "usuario3");
		Usuario u5 = new Usuario("usuario4", "usuario4");
		Usuario u6 = new Usuario("sergio", "sergio");
		Usuario u7 = new Usuario("aem", "aem");
		Usuario u8 = new Usuario("paty", "paty");
		
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);
		usuarios.add(u5);
		usuarios.add(u6);
		usuarios.add(u7);
		usuarios.add(u8);
	}
	
	
	public Usuario findUsuario(String username) {
		return usuarios.stream()
				  .filter(usuario -> username.equals(usuario.getUsername()))
				  .findFirst()
				  .orElse(null);
	}
	
	public boolean autenticar(String username, String password) {
		boolean autenticar = false;
		
		Usuario usuario = findUsuario(username);
		
		if (usuario != null && usuario.getPassword().equals(password)) {
			autenticar = true;
		}
		return autenticar;
	}
}
