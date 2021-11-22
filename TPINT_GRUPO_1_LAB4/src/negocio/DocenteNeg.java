package negocio;

import java.util.ArrayList;


import entidad.Docente;

public interface DocenteNeg {
	int agregar(Docente docente, String constrasenia);
	public ArrayList<Docente> obtenerTodos();
	public ArrayList<Docente> obtenerTodos(int legajo);
	public int eliminar(int legajo);
	public Docente obtenerUno(int legajo);
	public int modificar(Docente doc);
	
}
