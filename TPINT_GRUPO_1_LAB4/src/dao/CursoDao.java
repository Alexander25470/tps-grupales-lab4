package dao;

import java.util.ArrayList;

import entidad.Curso;

public interface CursoDao {
	
	public int agregar(Curso curso);
	public ArrayList<Curso> obtenerTodos();

}
