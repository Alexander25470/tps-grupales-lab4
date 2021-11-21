package daolmpl;

import java.sql.ResultSet;

import dao.UsuarioDao;
import entidad.Alumno;
import entidad.Nacionalidad;
import entidad.Provincia;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario login(String usuario, String contrasenia) {
		Conexion cn = new Conexion();
		cn.AbrirConexion();
		Usuario user = new Usuario();
		try
		 {
			 ResultSet rs= cn.query("SELECT * FROM usuarios WHERE nombre ='"+usuario+"' and contrasenia = '"+contrasenia+"' LIMIT 1");
			 if(rs.next()) {
				 user.setId(rs.getInt("id"));
				 user.setLegajoDocente(rs.getInt("legajo_docente"));
				 user.setNombre(rs.getString("nombre"));
				 user.setAdmin(rs.getBoolean("administrador"));
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return user;
	}
}
