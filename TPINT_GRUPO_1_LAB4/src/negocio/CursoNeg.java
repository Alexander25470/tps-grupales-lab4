package negocio;

import java.util.ArrayList;

import entidad.Curso;

public interface CursoNeg {
	
	public int agregar(Curso curso);
	public ArrayList<Curso> obtenerTodos();

}
