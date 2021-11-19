package negociolmpl;

import java.util.ArrayList;

import dao.NotaDao;
import daolmpl.Conexion;
import daolmpl.NotaDaoImpl;
import entidad.Nota;
import negocio.NotaNeg;

public class NotaNegImpl implements NotaNeg {
	NotaDao nd = new NotaDaoImpl();

	@Override
	public ArrayList<Nota> obtenerNotasCurso(int idCurso) {
		// TODO Auto-generated method stub
		return nd.obtenerNotasCurso(idCurso);
	}
	
	@Override
	public int agregar(int legajoAlumno, int idCurso) {
		return nd.agregar(legajoAlumno, idCurso);
	}

	@Override
	public int modificarNota(int legajo, int nota, String examen,int idCurso) {
		// TODO Auto-generated method stub
		return nd.modificarNota(legajo, nota, examen, idCurso);
	}

	@Override
	public ArrayList<Nota> obtenerNotasCurso(int idCurso, int legajo) {
		// TODO Auto-generated method stub
		return nd.obtenerNotasCurso(idCurso, legajo);
	}

	@Override
	public int modificarEstado(int legajo, int estado, int idCurso) {
		// TODO Auto-generated method stub
		return nd.modificarEstado(legajo, estado, idCurso);
	}

}
