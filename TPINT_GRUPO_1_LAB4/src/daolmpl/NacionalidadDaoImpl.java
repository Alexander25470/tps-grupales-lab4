package daolmpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.NacionalidadDao;
import entidad.Nacionalidad;

public class NacionalidadDaoImpl implements NacionalidadDao {

	@Override
	public ArrayList<Nacionalidad> obtenerTodos() {
		Conexion cn = new Conexion();
		ArrayList<Nacionalidad> nacionalidad = new ArrayList<Nacionalidad>();
		try
		 {
			cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT * FROM nacionalidades;");
			 while(rs.next())
			 {
				 Nacionalidad nac = new Nacionalidad();
	
				 nac.setId(rs.getInt("id"));
				 nac.setNombre(rs.getString("Nombre"));
				 
				 
				 nacionalidad.add(nac);
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
		return nacionalidad;
	}

}
