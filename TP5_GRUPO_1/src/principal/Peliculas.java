package principal;

public class Peliculas {
	int id;
	String nombre;
	Genero genero;
	static int cont = 0;
	public Peliculas(String nombre, Genero genero) {
		cont++;
		this.id = cont;
		this.nombre = nombre;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return id + " - " + nombre + " - " + genero.toString();
	}	
	
}
