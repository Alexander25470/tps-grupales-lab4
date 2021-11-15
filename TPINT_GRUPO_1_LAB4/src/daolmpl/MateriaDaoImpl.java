package daolmpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.MateriaDao;
import entidad.Materia;


public class MateriaDaoImpl implements MateriaDao {

	@Override
	public ArrayList<Materia> obtenerTodos() {
		Conexion cn = new Conexion();
		ArrayList<Materia> materia = new ArrayList<Materia>();
		try
		 {
			cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT * FROM materias;");
			 while(rs.next())
			 {
				 Materia mat = new Materia();
	
				 mat.setId(rs.getInt("id"));
				 mat.setNombre(rs.getString("nombre"));
				 
				 
				 materia.add(mat);
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
		return materia;
	}
	
	

}
