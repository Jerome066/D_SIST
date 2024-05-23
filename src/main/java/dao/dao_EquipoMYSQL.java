package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;

public class dao_EquipoMYSQL implements dao_Equipo{

	private Connection con;

	DataSource ds = null;

	InitialContext cxt = null;

	ResultSet resultset = null;
	Statement statement = null;
	
	public dao_EquipoMYSQL(Connection c) throws ServletException {
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
	
	public boolean AltaEquipo(Equipo eq) {
		boolean band = false;
		
		String nom = eq.getNombre(); 
		String marc = eq.getMarca();
		String desc = eq.getDescripcion();
		int cant = eq.getCantidad();
		
		
		try {

			// manda el QUERY a la BD y regresa si se realizo o no
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			String strSelect = "INSERT INTO Equipo (Nombre, Marca, Descripcion, Cantidad)"
					+ "VALUES ('"+ eq.getNombre() +"', '"+eq.getMarca()+"', '"+eq.getDescripcion()+"', "+eq.getCantidad()+");"; 
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
	
	
	public boolean BajaEquipo(Equipo eq) {
		boolean band = false;
		
		int id = eq.getID();
		
		
		try {

			// manda el QUERY a la BD y regresa si se realizo o no
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			String strSelect = "DELETE FROM Equipo WHERE IdEquipo = "+eq.getID()+";"; // quitar este query ejemplo
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
	
	
	public boolean ModificacionEquipo(Equipo eq) {
		boolean band = false;
		
		int id = eq.getID();
		String nom = eq.getNombre();
		String marc = eq.getMarca();
		String desc = eq.getDescripcion();
		int cant = eq.getCantidad();
		
		
		try {

			// manda el QUERY a la BD y regresa si se realizo o no
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			String strSelect = "UPDATE Equipo "
					+ "SET Nombre = '"+eq.getNombre()+"', Marca = '"+eq.getMarca()+"', Descripcion = '"+eq.getDescripcion()+"', Cantidad = "+eq.getCantidad()+""
					+ "WHERE IdEquipo = "+eq.getID()+";";
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
	
	public ArrayList<Equipo> ReporteEquipos(){
		ArrayList<Equipo> lista = new ArrayList();
		
		try {

			// obtiene los valores de la tabla de Usuario
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			String strSelect = "SELECT * FROM Equipo;"; // quitar este query ejemplo
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {
				// Acceder a los valores de cada fila
				int i = resultados.getInt("IdEquipo");
				String nomb = resultados.getString("Nombre");
				String marc = resultados.getString("Marca");
				String des = resultados.getString("Descripcion");
				int r = resultados.getInt("Cantidad");

				Equipo e = new Equipo();
				lista.add(e);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return lista;
	}
	
	
	public Equipo ReporteEquipo(int id){
		Equipo eq = null;
		
		try {

			// obtiene los valores de la tabla de Usuario
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			String strSelect = "SELECT * FROM Equipo WHERE IdEquipo = "+id+";"; // quitar este query ejemplo
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {
				// Acceder a los valores de cada fila
				int i = resultados.getInt("IdEquipo");
				String nomb = resultados.getString("Nombre");
				String marc = resultados.getString("Marca"); 
				String des = resultados.getString("Descripcion");
				int r = resultados.getInt("Cantidad");

				eq = new Equipo(i,nomb,marc,des,r);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return eq;
	}

}
