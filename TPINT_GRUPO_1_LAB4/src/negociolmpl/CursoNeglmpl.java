package negociolmpl;

import java.util.ArrayList;

import dao.CursoDao;
import daolmpl.CursoDaolmpl;
import entidad.Alumno;
import entidad.Curso;
import negocio.CursoNeg;

public class CursoNeglmpl implements CursoNeg {
	CursoDao CurDao = new CursoDaolmpl();
	@Override
	public int agregar(Curso curso) {
		
		return CurDao.agregar(curso);
	}
	@Override
	public ArrayList<Curso> obtenerTodos() {
		
		return CurDao.obtenerTodos();
	}
	@Override
	public ArrayList<Curso> obtenerTodos(int anio) {
		
		return CurDao.obtenerTodos(anio);
	}
	@Override
	public ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(int idCurso) {
		return CurDao.obtenerAlumnosQueNoEstanEnCurso(idCurso);
	}
	@Override
	public ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(int idCurso, int legajo) {
		return CurDao.obtenerAlumnosQueNoEstanEnCurso(idCurso, legajo);
	}

}
