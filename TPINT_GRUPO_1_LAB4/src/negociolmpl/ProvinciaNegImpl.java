package negociolmpl;

import java.util.ArrayList;

import dao.ProvinciaDao;
import daolmpl.ProvinciaDaoImpl;
import entidad.Provincia;
import negocio.ProvinciaNeg;

public class ProvinciaNegImpl implements ProvinciaNeg {
	ProvinciaDao ProvDao = new ProvinciaDaoImpl();
	@Override
	public ArrayList<Provincia> obtenerTodos() {
		// TODO Auto-generated method stub
		return ProvDao.obtenerTodos();
	}
	
	

}
