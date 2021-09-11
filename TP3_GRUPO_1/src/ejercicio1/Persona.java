package ejercicio1;

public class Persona {
	String dni;
	String nombre;
	String apellido;
	
	public Persona(String dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Persona(String personaTexto){
		String partesPersona[] = personaTexto.split("-");
		
		
		// verificarDniInvalido(partesPersona[0]);
		
		this.dni = partesPersona[0];
		this.nombre = partesPersona[1];
		this.apellido = partesPersona[2];
	}
	
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
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
}
