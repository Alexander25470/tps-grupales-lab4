package negocio;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.Curso;

public interface CursoNeg {
	
	public int agregar(Curso curso);
	public ArrayList<Curso> obtenerTodos();
	public ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(int idCurso);
	ArrayList<Curso> obtenerTodos(int anio);
	ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(int idCurso, int legajo);

}
