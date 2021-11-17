package daolmpl;


import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DocenteDao;
import entidad.Docente;
import entidad.Localidad;
import entidad.Nacionalidad;

public class DocenteDaolmpl implements DocenteDao {	
		
	@Override
	public int agregar(Docente docente) {
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			cn.AbrirConexion();
			
			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into Docentes(dni, nombreApellido,FechaNac,ID_Nacionalidad, ID_Localidad, "
			+ "direccion,email,telefono)values('"+docente.getDni()+"','"+docente.getNombreApellido()+"','"+docente.getFechaNac()+"',"
			+ "'"+docente.getNacionalidad().getId()+"','"+docente.getLocalidad().getId()+"','"+docente.getDireccion()+"','"+docente.getEmail()+"','"+docente.getTelefono()+"')";
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;

	}
	
	public ArrayList<Docente> obtenerTodos(){
		Conexion cn = new Conexion();
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		try
		 {
			cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT doc.*, nac.Nombre as nombreNac, loc.Nombre as nombreLoc FROM docentes "+
			"doc inner join nacionalidades nac on doc.ID_Nacionalidad = nac.id inner join localidades"+
					 " loc on doc.ID_Localidad = loc.id where doc.estado != 0");
			 while(rs.next())
			 {
				 Docente doc = new Docente();
				 Nacionalidad nac = new Nacionalidad();
				 Localidad loc = new Localidad();
				 doc.setLegajo(rs.getInt("legajo"));
				 doc.setDni(rs.getString("dni"));
				 doc.setNombreApellido(rs.getString("nombreApellido"));
				 doc.setFechaNac(rs.getString("fechaNac"));
				 
				 nac.setId(Integer.parseInt(rs.getString("ID_Nacionalidad")));
				 nac.setNombre(rs.getString("nombreNac"));
				 doc.setNacionalidad(nac);
				 
				 loc.setId(Integer.parseInt(rs.getString("ID_Localidad")));
				 loc.setNombre(rs.getString("nombreLoc"));
				 doc.setLocalidad(loc);
				 
				 doc.setDireccion(rs.getString("direccion"));
				 doc.setEmail(rs.getString("email"));
				 doc.setTelefono(rs.getString("telefono"));
				 
				 docentes.add(doc);
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
		return docentes;
	}

	@Override
	public int eliminar(int legajo) {
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			
			cn.AbrirConexion();

			String query = "update docentes set estado = 0 where legajo = "+legajo;
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
		
	}


}
