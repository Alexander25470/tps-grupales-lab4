package negociolmpl;

import entidad.Alumno;
import negocio.AlumnoNeg;
import dao.AlumnoDao;
import daolmpl.AlumnoDaolmpl;

public class AlumnoNeglmpl implements AlumnoNeg {
	AlumnoDao alumDao = new AlumnoDaolmpl();
	@Override
	public int agregar(Alumno alumno) {
		
		return alumDao.agregar(alumno);
	}

}
