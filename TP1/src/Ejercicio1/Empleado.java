package Ejercicio1;

public class Empleado {
	
	private int id;
	private String nombre;
	private int edad;
	
	final int num_id=1000;
	static int cont = 0;
	
	public Empleado() {
		
		this.id = num_id + cont;
		this.nombre = "Sin nombre";
		this.edad = 99;
		
		cont++;

	}
	
	public Empleado(String nombre, int edad) {
		
		this.id = num_id+cont;
		this.nombre = nombre;
		this.edad = edad;
		
		cont++;
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

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	
	
}
