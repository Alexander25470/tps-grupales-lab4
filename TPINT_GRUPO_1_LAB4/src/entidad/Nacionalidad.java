package entidad;

public class Nacionalidad {
	private int id;
	private String nombre;
	
	public Nacionalidad() {
	}
	public Nacionalidad(int id) {
		this.id = id;
	}
	public Nacionalidad(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
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
}
