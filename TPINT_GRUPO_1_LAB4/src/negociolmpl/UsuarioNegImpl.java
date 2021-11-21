package negociolmpl;

import dao.UsuarioDao;
import daolmpl.UsuarioDaoImpl;
import entidad.Alumno;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {
	// AlumnoDao alumDao = new AlumnoDaolmpl();
	UsuarioDao uDao = new UsuarioDaoImpl();
	@Override
	public Usuario login(String usuario, String contrasenia) {
		// TODO Auto-generated method stub
		return uDao.login(usuario, contrasenia);
	}
	
}