package negociolmpl;

import entidad.Alumno;
import negocio.AlumnoNeg;

import java.util.ArrayList;

import dao.AlumnoDao;
import daolmpl.AlumnoDaolmpl;

public class AlumnoNeglmpl implements AlumnoNeg {
	AlumnoDao alumDao = new AlumnoDaolmpl();
	@Override
	public int agregar(Alumno alumno) {
		
		return alumDao.agregar(alumno);
	}
	
	public ArrayList<Alumno> obtenerTodos(){
		return alumDao.obtenerTodos();
	}

	@Override
	public int eliminar(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumDao.eliminar(alumno);
	}

}
