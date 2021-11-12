package dao;


import java.util.ArrayList;

import entidad.Docente; 

public interface DocenteDao {
	
	public int agregar(Docente docente);
	public ArrayList<Docente> obtenerTodos();
	
}
