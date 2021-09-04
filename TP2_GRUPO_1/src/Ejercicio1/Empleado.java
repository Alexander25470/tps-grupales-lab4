package Ejercicio1;

public class Empleado {
	
	private int id;
	private String nombre;
	private int edad;
	
	static final int num_id=999;
	static int cont = 0;
	
	public Empleado() {		
		cont++;
		this.id = num_id + cont;
		this.nombre = "Sin nombre";
		this.edad = 99;
	}
	
	public Empleado(String nombre, int edad) {
		cont++;
		this.id = num_id+cont;
		this.nombre = nombre;
		this.edad = edad;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public static String devuelveProximoID() {
		return "El próximo ID será el "+ (num_id+cont+1);
	}
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
	
}
