package entidad;

public class Usuario {
	private int id;
	private String nombre;
	private boolean isAdmin;
	private int legajoDocente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getLegajoDocente() {
		return legajoDocente;
	}
	public void setLegajoDocente(int legajoDocente) {
		this.legajoDocente = legajoDocente;
	}
}
