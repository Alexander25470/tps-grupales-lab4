package negocio;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoNeg {
	
	public int agregar(Alumno alumno);
	public ArrayList<Alumno> obtenerTodos();
	public ArrayList<Alumno> obtenerTodos(int legajo);
	public int eliminar(int legajo);
	public Alumno obtenerUno(int legajo);
	public int modificar(Alumno alu);

}
