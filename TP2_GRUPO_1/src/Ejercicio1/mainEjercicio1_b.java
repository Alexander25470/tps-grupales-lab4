package Ejercicio1;

import java.util.TreeSet;
import java.util.Iterator;

public class mainEjercicio1_b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Profesor> profesores = new TreeSet<Profesor>();
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		profesores.add( new Profesor() );
		
		Iterator<Profesor> it = profesores.iterator();
		while (it.hasNext()) {
			Profesor profesor = it.next();
			it.remove();
			System.out.println(profesor.toString());
		}
	}

}
