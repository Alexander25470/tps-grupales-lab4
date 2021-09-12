package ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


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
		Archivo res = new Archivo();
		res.setRuta("Resultado.txt");
		
		ArrayList<String> personasEnTexto = ar.lee_lineas();
		TreeSet<Persona> tsPersonas = new TreeSet<Persona>();
		
		for (String persona : personasEnTexto) {
			try {
				Persona per = new Persona(persona);
				tsPersonas.add(per);
			} catch (DniInvalido ex) {
				System.out.println(ex.getMessage()+": "+persona);
			}
			 catch (Exception ex) {
					// System.out.println(ex.getMessage()+": "+persona);
			}
		}
		
		Iterator<Persona> it = tsPersonas.iterator();
		while (it.hasNext()) {
			Persona persona = it.next();
			it.remove();
			res.escribeLineas(persona.toString());
			System.out.println(persona.toString());
		}
	}
	

}
