package dao;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoDao {
	
	public int agregar(Alumno alumno);
	public ArrayList<Alumno> obtenerTodos();
	public ArrayList<Alumno> obtenerTodos(int legajo);
	public int eliminar(int legajo);
	public Alumno obtenerUno(int legajo);

}
