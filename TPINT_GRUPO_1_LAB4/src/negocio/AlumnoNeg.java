package negocio;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnoNeg {
	
	public int agregar(Alumno alumno);
	public ArrayList<Alumno> obtenerTodos();
	public int eliminar(Alumno alumno);

}
