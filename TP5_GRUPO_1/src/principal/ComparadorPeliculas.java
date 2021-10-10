package principal;

import java.util.Comparator;

public class ComparadorPeliculas implements Comparator<Peliculas> {

	@Override
	public int compare(Peliculas arg0, Peliculas arg1) {
		// TODO Auto-generated method stub
		return arg0.nombre.compareTo(arg1.toString());
	}


}
