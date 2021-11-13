package dao;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoDao {
	
	public int agregar(Alumno alumno);
	public ArrayList<Alumno> obtenerTodos();

}
