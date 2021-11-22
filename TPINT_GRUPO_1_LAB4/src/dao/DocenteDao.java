package dao;


import java.util.ArrayList;

import entidad.Docente; 

public interface DocenteDao {
	
	public int agregar(Docente docente, String contrasenia);
	public ArrayList<Docente> obtenerTodos();
	public ArrayList<Docente> obtenerTodos(int legajo);
	public int eliminar(int legajo);
	public Docente obtenerUno(int legajo);
	int modificar(Docente doc);
}
