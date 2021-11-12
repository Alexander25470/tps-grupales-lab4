package negocio;

import java.util.ArrayList;

import entidad.Docente;

public interface DocenteNeg {
	
	public int agregar(Docente docente);
	public ArrayList<Docente> obtenerTodos();

}
