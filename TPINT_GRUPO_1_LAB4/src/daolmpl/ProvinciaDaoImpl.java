package daolmpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao {

	@Override
	public ArrayList<Provincia> obtenerTodos() {
		Conexion cn = new Conexion();
		ArrayList<Provincia> provincia = new ArrayList<Provincia>();
		try
		 {
			cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT * FROM provincias;");
			 while(rs.next())
			 {
				 Provincia prov = new Provincia();
	
				 prov.setId(rs.getInt("id"));
				 prov.setNombre(rs.getString("Nombre"));
				 
				 
				 provincia.add(prov);
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
		return provincia;
	}
	
	

}
