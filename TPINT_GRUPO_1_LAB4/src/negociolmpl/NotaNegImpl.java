package negociolmpl;

import java.util.ArrayList;

import dao.NotaDao;
import daolmpl.NotaDaoImpl;
import entidad.Nota;
import negocio.NotaNeg;

public class NotaNegImpl implements NotaNeg {
	NotaDao nd = new NotaDaoImpl();

	@Override
	public ArrayList<Nota> obtenerNotasCurso(int idCurso) {
		// TODO Auto-generated method stub
		return nd.obtenerNotasCurso(idCurso);
	}

}
