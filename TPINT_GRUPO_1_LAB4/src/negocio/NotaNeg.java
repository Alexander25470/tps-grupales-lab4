package negocio;

import java.util.ArrayList;

import entidad.Nota;

public interface NotaNeg {
	public ArrayList<Nota> obtenerNotasCurso(int idCurso);
	public int modificarNota(int legajo, int nota, String examen,int idCurso);
	int agregar(int legajoAlumno, int idCurso);
}
