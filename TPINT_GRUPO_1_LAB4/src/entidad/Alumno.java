package entidad;

public class Alumno {
	
	private int legajo;
	private String dni;
	private String nombreApellido;
	private String fechaNac;
	private int idProvincia;
	private int idNacionalidad;
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
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public int getIdNacionalidad() {
		return idNacionalidad;
	}
	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", dni=" + dni + ", nombreApellido=" + nombreApellido + ", fechaNac="
				+ fechaNac + ", idProvincia=" + idProvincia + ", idNacionalidad=" + idNacionalidad + ", direccion="
				+ direccion + ", email=" + email + ", telefono=" + telefono + "]";
	}

	
	
}
