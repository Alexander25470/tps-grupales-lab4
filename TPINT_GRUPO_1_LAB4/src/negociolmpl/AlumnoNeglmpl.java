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
	
	public ArrayList<Alumno> obtenerTodos(int legajo){
		return alumDao.obtenerTodos(legajo);
	}

	@Override
	public int eliminar(int legajo) {
		// TODO Auto-generated method stub
		return alumDao.eliminar(legajo);
	}

	@Override
	public Alumno obtenerUno(int legajo) {
		// TODO Auto-generated method stub
		return alumDao.obtenerUno(legajo);
	}

}
