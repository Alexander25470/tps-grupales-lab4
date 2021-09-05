package ejercicio3;

import java.util.ArrayList;
import java.util.ListIterator;


public class mainEjercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edificio> edificios = new ArrayList<Edificio>();
		edificios.add( new Polideportivo() );
		edificios.add( new Polideportivo() );
		edificios.add( new Polideportivo() );
		edificios.add( new EdificioDeOficinas() );
		edificios.add( new EdificioDeOficinas() );
		
		ListIterator<Edificio> it = edificios.listIterator();
		while (it.hasNext()) {
			Edificio edif = it.next();
			it.remove();
			System.out.println(edif.toString());
		}
		
	}

}
