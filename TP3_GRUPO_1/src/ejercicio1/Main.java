package ejercicio1;

import java.util.ArrayList;
import java.util.ListIterator;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {			
			Persona.verificarDniInvalido("12441981");
		} catch (DniInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Archivo ar = new Archivo();
		ar.setRuta("Personas.txt");
		
		ArrayList<String> personasEnTexto = ar.lee_lineas();
		
		for (String persona : personasEnTexto) {
			try {				
				Persona per = new Persona(persona);
				System.out.println(per.toString());
			} catch (Exception ex) {
				// ex.printStackTrace();
			}
		}
	}
	

}
