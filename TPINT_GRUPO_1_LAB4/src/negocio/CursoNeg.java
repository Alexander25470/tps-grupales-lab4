package negocio;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.Curso;

public interface CursoNeg {
	
	public int agregar(Curso curso);
	public ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(int idCurso);
	ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(int idCurso, int legajo);
	ArrayList<Curso> obtenerTodos(int anio, int legajo);

}
