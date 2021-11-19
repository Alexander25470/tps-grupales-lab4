package dao;

import java.util.ArrayList;
import entidad.Nota;

public interface NotaDao {
	public ArrayList<Nota> obtenerNotasCurso(int idCurso);
	int agregar(int legajoAlumno, int idCurso);
	public int modificarNota(int legajo, int nota, String examen, int idCurso);
	public ArrayList<Nota> obtenerNotasCurso(int idCurso, int legajo);
	public int modificarEstado(int legajo, int estado, int idCurso);
	
}
 