package dao;

import java.util.ArrayList;
import entidad.Nota;

public interface NotaDao {
	public ArrayList<Nota> obtenerNotasCurso(int idCurso);
}
 