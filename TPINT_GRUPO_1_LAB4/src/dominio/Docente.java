package dominio;

public class Docente {
	
	private int legajo;
	private String dni;
	private String nombreApellido;
	private String fechaNac;
	private int id_nacionalidad;
	private int id_Localidad;
	private String direccion;
	private String email;
	private String telefono;
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public int getId_nacionalidad() {
		return id_nacionalidad;
	}
	public void setId_nacionalidad(int id_nacionalidad) {
		this.id_nacionalidad = id_nacionalidad;
	}
	public int getId_Localidad() {
		return id_Localidad;
	}
	public void setId_Localidad(int id_Localidad) {
		this.id_Localidad = id_Localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Docente [legajo=" + legajo + ", dni=" + dni + ", nombreApellido=" + nombreApellido + ", fechaNac="
				+ fechaNac + ", id_nacionalidad=" + id_nacionalidad + ", id_Localidad=" + id_Localidad + ", direccion="
				+ direccion + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
	

}
