package principal;

public class Peliculas {
	int id;
	String nombre;
	Genero genero;
	static int cont = 1;
	public Peliculas(String nombre, Genero genero) {
		this.id = cont;
		this.nombre = nombre;
		this.genero = genero;
		cont++;
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
		return nombre + " - " + genero.toString();
	}	
	
}
