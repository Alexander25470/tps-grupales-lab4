package Ejercicio1;

public class Empleado {
	
	private final int id;
	private String nombre;
	private int edad;
	private static int num_id = 1000;
	
	public Empleado() {
		
		this.id = num_id;
		this.nombre = "Sin nombre";
		this.edad = 99;
		
		num_id++;

	}
	
	public Empleado(String nombre, int edad) {
		
		this.id = num_id;
		this.nombre = nombre;
		this.edad = edad;
		
		num_id++;
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
	
	
}
