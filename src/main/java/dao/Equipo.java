package dao;

public class Equipo {
	
	private int ID;
	private String Nombre;
	private String Marca;
	private String Descripcion;
	private int Cantidad;

	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	public Equipo(String marca, String descripcion, int cantidad) {
		super();
		Marca = marca;
		Descripcion = descripcion;
		Cantidad = cantidad;
	}
	
	public Equipo(int iD, String marca, String descripcion, int cantidad) {
		super();
		ID = iD;
		Marca = marca;
		Descripcion = descripcion;
		Cantidad = cantidad;
	}
	
	public Equipo(int iD) {
		super();
		ID = iD;
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
}
