package negociolmpl;

import java.util.ArrayList;

import dao.LocalidadDao;
import daolmpl.LocalidadDaoImpl;
import entidad.Localidad;
import negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg {
	LocalidadDao LocDao = new LocalidadDaoImpl();
	@Override
	public ArrayList<Localidad> obtenerTodos() {
		// TODO Auto-generated method stub
		return LocDao.obtenerTodos();
	}

}
