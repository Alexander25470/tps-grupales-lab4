package negociolmpl;

import java.util.ArrayList;

import dao.CursoDao;
import daolmpl.CursoDaolmpl;
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

}