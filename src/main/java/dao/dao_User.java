package dao;

import java.util.ArrayList;

public interface dao_User {
	
	boolean AltaUsuario(User usuario);
	boolean BajaUsuario(User usuario);
	boolean ModificacionUsuario(User usuario);
	ArrayList<User> ReporteUsuarios(User usuario);
}
