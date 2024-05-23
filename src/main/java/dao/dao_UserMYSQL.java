package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;

public class dao_UserMYSQL implements dao_User {

	private Connection con;

	DataSource ds = null;

	InitialContext cxt = null;

	ResultSet resultset = null;
	Statement statement = null;

	public dao_UserMYSQL() throws ServletException {

		InitialContext cxt;
		try {
			cxt = new InitialContext();
			if (cxt != null) {
				this.ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/ds");
				if (this.ds == null) {
					throw new ServletException(" no se encontró e data source");
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public boolean AltaUsuario(User usuario) {
		boolean band = false;

		
		String nombre = usuario.getNombre();
		String correo = usuario.getCorreo();
		int telefono = usuario.getTelefono();
		String Rol = usuario.getRol();
		String password = usuario.getPassword();
		
		
		try {

			// manda el QUERY a la BD y regresa si se realizo o no

			Statement stmt = con.createStatement();
			String strSelect = "INSERT INTO Usuario (Nombre, CorreoElectronico, TelefonoCelular, TipoUsuario)"
					+ "VALUES ('" + usuario.getNombre() + "', '" + usuario.getCorreo() + "', '"+usuario.getTelefono()+"', '"+usuario.getRol()+"');"; 
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {

				if (resultados != null) {
					band = true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return band;
	}

	public boolean BajaUsuario(User usuario) {
		boolean band = false;

		try {

			/// manda el QUERY a la BD y regresa si se realizo o no

			Statement stmt = con.createStatement();
			String strSelect = "DELETE FROM Usuario WHERE IdUsuario = "+usuario.getId() +";"; // quitar este query ejemplo
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {

				if (resultados != null) {
					band = true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return band;
	}

	public boolean ModificacionUsuario(User usuario) {
		boolean band = false;

		try {

			/// manda el QUERY a la BD y regresa si se realizo o no

			Statement stmt = con.createStatement();
			String strSelect = "UPDATE Usuario"
					+ "SET Nombre = '"+usuario.getNombre()+"', CorreoElectronico = '"+usuario.getCorreo()+"', TelefonoCelular = '"+usuario.getTelefono()+"', TipoUsuario = '"+usuario.getRol()+"'"
					+ "WHERE IdUsuario = "+usuario.getId()+";"; // quitar este query ejemplo
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {

				if (resultados != null) {
					band = true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return band;
	}

	public ArrayList<User> ReporteUsuarios(User usuario) { // array de clase usuarios
		boolean band = false;
		ArrayList<User> ALL_USERS = new ArrayList();

		try {

			// obtiene los valores de la tabla de Usuario

			Statement stmt = con.createStatement();
			String strSelect = "SELECT * FROM Usuario;"; // quitar este query ejemplo
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {
				// Acceder a los valores de cada fila
				int i = resultados.getInt("IdUsuario");
				String nomb = resultados.getString("Nombre");
				String corr = resultados.getString("CorreoElectronico");
				int tel = resultados.getInt("TelefonoCelular");
				String r = resultados.getString("TipoUsuario");

				User u = new User(nomb, corr, tel, r, "");
				ALL_USERS.add(u);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ALL_USERS;
	}

	public User ReporteUsuario(User usuario) { // array de clase usuarios
		boolean band = false;
		User u = null;

		try {

			// obtiene los valores de la tabla de Usuario

			Statement stmt = con.createStatement();
			String strSelect = "SELECT * FROM Usuario WHERE IdUsuario = "+usuario.getId()+";"; // quitar este query ejemplo
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {
				// Acceder a los valores de cada fila
				int i = resultados.getInt("IdUsuario");
				String nomb = resultados.getString("Nombre");
				String corr = resultados.getString("CorreoElectronico");
				int tel = resultados.getInt("TelefonoCelular");
				String r = resultados.getString("TipoUsuario");

				u = new User(nomb, corr, tel, r, "");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

}
