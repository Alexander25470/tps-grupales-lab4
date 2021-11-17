package negociolmpl;

import java.util.ArrayList;

import dao.MateriaDao;
import daolmpl.MateriaDaoImpl;
import entidad.Materia;
import negocio.MateriaNeg;

public class MateriaNegImpl implements MateriaNeg {
	MateriaDao matDao = new MateriaDaoImpl();
	@Override
	public ArrayList<Materia> obtenerTodos() {
		
		return matDao.obtenerTodos();
	}
	
	

}
