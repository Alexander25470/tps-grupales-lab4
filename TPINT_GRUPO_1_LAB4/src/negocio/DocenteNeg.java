package negocio;

import java.util.ArrayList;


import entidad.Docente;

public interface DocenteNeg {
	
	public int agregar(Docente docente);
	public ArrayList<Docente> obtenerTodos();
	public ArrayList<Docente> obtenerTodos(int legajo);
	public int eliminar(int legajo);
	
}
