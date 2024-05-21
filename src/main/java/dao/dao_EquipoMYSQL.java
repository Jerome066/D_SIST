package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dao_EquipoMYSQL implements dao_Equipo{

	private Connection con;
	
	public dao_EquipoMYSQL(Connection c) {
		this.con = c;
	}
	
	public boolean AltaEquipo(Equipo eq) {
		boolean band = false;
		
		String nom = eq.getNombre();
		String marc = eq.getMarca();
		String desc = eq.getDescripcion();
		int cant = eq.getCantidad();
		
		
		try {

			// manda el QUERY a la BD y regresa si se realizo o no

			Statement stmt = con.createStatement();
			String strSelect = "SELECT DATABASE();"; // quitar este query ejemplo
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

			Statement stmt = con.createStatement();
			String strSelect = "SELECT DATABASE();"; // quitar este query ejemplo
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

			Statement stmt = con.createStatement();
			String strSelect = "SELECT DATABASE();"; // quitar este query ejemplo
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

			Statement stmt = con.createStatement();
			String strSelect = "SELECT DATABASE();"; // quitar este query ejemplo
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

			Statement stmt = con.createStatement();
			String strSelect = "SELECT DATABASE();"; // quitar este query ejemplo
			ResultSet resultados = stmt.executeQuery(strSelect);

			while (resultados.next()) {
				// Acceder a los valores de cada fila
				int i = resultados.getInt("IdEquipo");
				String nomb = resultados.getString("Nombre");
				String marc = resultados.getString("Marca");
				String des = resultados.getString("Descripcion");
				int r = resultados.getInt("Cantidad");

				eq = new Equipo();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return eq;
	}

}
