package negociolmpl;

import java.util.ArrayList;

import dao.NacionalidadDao;
import daolmpl.NacionalidadDaoImpl;
import entidad.Nacionalidad;
import negocio.NacionalidadNeg;

public class NacionalidadNegImpl implements NacionalidadNeg {
	NacionalidadDao nacDao = new NacionalidadDaoImpl();
	@Override
	public ArrayList<Nacionalidad> obtenerTodos() {
		// TODO Auto-generated method stub
		return nacDao.obtenerTodos();
	}
	
	

}
