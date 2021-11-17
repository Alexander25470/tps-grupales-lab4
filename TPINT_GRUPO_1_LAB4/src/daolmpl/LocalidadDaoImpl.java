package daolmpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.LocalidadDao;
import entidad.Localidad;


public class LocalidadDaoImpl implements LocalidadDao {

	@Override
	public ArrayList<Localidad> obtenerTodos() {
		Conexion cn = new Conexion();
		ArrayList<Localidad> localidad = new ArrayList<Localidad>();
		try
		 {
			cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT * FROM Localidades;");
			 while(rs.next())
			 {
				 Localidad loc = new Localidad();
	
				 loc.setId(rs.getInt("id"));
				 loc.setNombre(rs.getString("Nombre"));
				 
				 
				 localidad.add(loc);
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
		return localidad;
	}

	
}
