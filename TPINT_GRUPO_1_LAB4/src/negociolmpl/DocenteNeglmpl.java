package negociolmpl;

import java.util.ArrayList;

import dao.DocenteDao;
import daolmpl.DocenteDaolmpl;
import entidad.Docente;
import negocio.DocenteNeg;

public class DocenteNeglmpl implements DocenteNeg {
	DocenteDao DocDao = new DocenteDaolmpl();
	@Override
	public int agregar(Docente docente, String constrasenia) {
		
		return DocDao.agregar(docente, constrasenia);
	}
	
	public ArrayList<Docente> obtenerTodos(){
		return DocDao.obtenerTodos();
	}

	@Override
	public int eliminar(int legajo) {
		// TODO Auto-generated method stub
		return DocDao.eliminar(legajo);
	}
	
	public ArrayList<Docente> obtenerTodos(int legajo){
		return DocDao.obtenerTodos(legajo);
	}

	@Override
	public Docente obtenerUno(int legajo) {
		// TODO Auto-generated method stub
		return DocDao.obtenerUno(legajo);
	}

	@Override
	public int modificar(Docente doc) {
		// TODO Auto-generated method stub
		return DocDao.modificar(doc);
	}
}
