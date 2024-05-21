package dao;

public class User {

	private int Id;
	private String Nombre;
	private String Correo;
	private int Telefono;
	private String Rol;
	
	private String Password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String nombre, String correo, int telefono, String rol, String password) {
		super();
		this.Nombre = nombre;
		this.Correo = correo;
		this.Telefono = telefono;
		this.Rol = rol;
		this.Password = password;
	}
	
	
	public User(int id) {
		super();
		this.Id = id;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}
	
	public String getPassword() {
		return Rol;
	}

	public void setPassword(String rol) {
		Rol = rol;
	}

}
