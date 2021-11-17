package negocio;

import java.util.ArrayList;

import entidad.Nota;

public interface NotaNeg {
	public ArrayList<Nota> obtenerNotasCurso(int idCurso);

	int agregar(int legajoAlumno, int idCurso);
}
