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
	public ArrayList<Alumno> obtenerAlumnosQueNoEstanEnCurso(Curso curso) {
		return CurDao.obtenerAlumnosQueNoEstanEnCurso(curso);
	}

}
