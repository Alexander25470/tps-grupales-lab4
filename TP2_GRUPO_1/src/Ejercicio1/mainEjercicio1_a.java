package Ejercicio1;

import java.util.ArrayList;
import java.util.ListIterator;

public class mainEjercicio1_a {

	public static void main(String[] args) {
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		
		ListIterator<Profesor> it = profesores.listIterator();
		while (it.hasNext()) {
			Profesor profesor = it.next();
			it.remove();
			System.out.println(profesor.toString());
		}
	}
}
