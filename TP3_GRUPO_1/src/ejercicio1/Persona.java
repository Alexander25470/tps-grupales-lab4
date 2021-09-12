package ejercicio1;

import java.io.IOException;

public class Persona implements Comparable{
	String dni;
	String nombre;
	String apellido;
	
	public Persona(String dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Persona(String personaTexto) throws DniInvalido, IOException{
		String partesPersona[] = personaTexto.split("-");
		if(partesPersona.length!=3) {
			throw new IOException("Texto incompleto");
		};	
		verificarDniInvalido(partesPersona[2]);

		this.nombre = partesPersona[0];
		this.apellido = partesPersona[1];
		this.dni = partesPersona[2];
	}
	
	@Override
	public String toString() {
		return nombre+"-"+apellido+"-"+dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public static void verificarDniInvalido(String dni) throws DniInvalido {
		try {  
		    Integer.parseInt(dni);  
		  } catch(NumberFormatException e){  
		    throw new DniInvalido();
		  }  
	}

	@Override
	public int compareTo(Object o) {
		Persona other = (Persona) o;
		return this.apellido.compareTo(other.apellido);
	}
	
}
