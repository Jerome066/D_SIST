package dao;

import java.util.ArrayList;

public interface dao_Equipo {

	boolean AltaEquipo(Equipo e);
	boolean BajaEquipo(Equipo e);
	boolean ModificacionEquipo(Equipo e);
	ArrayList<Equipo> ReporteEquipos();
	Equipo ReporteEquipo(int id);
	
}
