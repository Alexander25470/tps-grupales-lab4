package ejercicio1;

public class Persona {
	String dni;
	
	public static void verificarDniInvalido(String dni) throws DniInvalido {
		try {  
		    Integer.parseInt(dni);  
		  } catch(NumberFormatException e){  
		    throw new DniInvalido();
		  }  
	}
}
