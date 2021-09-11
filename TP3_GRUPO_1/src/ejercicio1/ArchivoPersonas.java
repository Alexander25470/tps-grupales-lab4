package ejercicio1;

public class ArchivoPersonas {
	String dni;
	
	public static void verificarDniInvalido(String dni) throws DniInvalido {
		try {  
		    Integer.parseInt(dni);  
		  } catch(NumberFormatException e){  
		    throw new DniInvalido();
		  }  
	}
}
