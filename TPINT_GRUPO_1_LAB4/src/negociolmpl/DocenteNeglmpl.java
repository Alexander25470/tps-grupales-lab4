package negociolmpl;

import dao.DocenteDao;
import daolmpl.DocenteDaolmpl;
import entidad.Docente;
import negocio.DocenteNeg;

public class DocenteNeglmpl implements DocenteNeg {
	DocenteDao DocDao = new DocenteDaolmpl();
	@Override
	public int agregar(Docente docente) {
		
		return DocDao.agregar(docente);
	}

}
