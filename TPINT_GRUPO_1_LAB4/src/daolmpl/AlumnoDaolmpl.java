package daolmpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.AlumnoDao;
import entidad.Alumno;
import entidad.Nacionalidad;
import entidad.Provincia;
import daolmpl.Conexion;

public class AlumnoDaolmpl implements AlumnoDao {
	
	public AlumnoDaolmpl(){
		
	}
	
	public int agregar(Alumno alumno) {
		
		
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			
			cn.AbrirConexion();

			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into Alumnos(dni, nombreApellido,FechaNac,ID_Nacionalidad, ID_Provincia, "
			+ "direccion,email,telefono)values('"+alumno.getDni()+"','"+alumno.getNombreApellido()+"','"+alumno.getFechaNac()+"',"
			+ "'"+alumno.getNacionalidad().getId()+"','"+alumno.getProvincia().getId()+"','"+alumno.getDireccion()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"')";
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
	}
	
	public ArrayList<Alumno> obtenerTodos(){
		Conexion cn = new Conexion();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try
		 {
			cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT alu.*, nac.Nombre as nombreNac, prov.Nombre as nombreProv FROM alumnos alu inner join nacionalidades nac on alu.ID_Nacionalidad = nac.id inner join provincias prov on alu.ID_Provincia = prov.id where alu.estado != 0;");
			 while(rs.next())
			 {
				 Alumno al = new Alumno();
				 Nacionalidad nac = new Nacionalidad();
				 Provincia prov = new Provincia();
				 al.setLegajo(rs.getInt("legajo"));
				 al.setDni(rs.getString("dni"));
				 al.setNombreApellido(rs.getString("nombreApellido"));
				 al.setFechaNac(rs.getString("fechaNac"));
				 
				 nac.setId(Integer.parseInt(rs.getString("ID_Nacionalidad")));
				 nac.setNombre(rs.getString("nombreNac"));
				 al.setNacionalidad(nac);
				 
				 prov.setId(Integer.parseInt(rs.getString("ID_Provincia")));
				 prov.setNombre(rs.getString("nombreProv"));
				 al.setProvincia(prov);
				 
				 al.setDireccion(rs.getString("direccion"));
				 al.setEmail(rs.getString("email"));
				 al.setTelefono(rs.getString("telefono"));
				 
				 alumnos.add(al);
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
		return alumnos;
	}

	public ArrayList<Alumno> obtenerTodos(int legajo){
		Conexion cn = new Conexion();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try
		 {
			cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT alu.*, nac.Nombre as nombreNac, prov.Nombre as nombreProv FROM alumnos alu inner join nacionalidades nac on alu.ID_Nacionalidad = nac.id inner join provincias prov on alu.ID_Provincia = prov.id where alu.estado != 0 and alu.legajo like '%"+legajo+"%';");
			 while(rs.next())
			 {
				 Alumno al = new Alumno();
				 Nacionalidad nac = new Nacionalidad();
				 Provincia prov = new Provincia();
				 al.setLegajo(rs.getInt("legajo"));
				 al.setDni(rs.getString("dni"));
				 al.setNombreApellido(rs.getString("nombreApellido"));
				 al.setFechaNac(rs.getString("fechaNac"));
				 
				 nac.setId(Integer.parseInt(rs.getString("ID_Nacionalidad")));
				 nac.setNombre(rs.getString("nombreNac"));
				 al.setNacionalidad(nac);
				 
				 prov.setId(Integer.parseInt(rs.getString("ID_Provincia")));
				 prov.setNombre(rs.getString("nombreProv"));
				 al.setProvincia(prov);
				 
				 al.setDireccion(rs.getString("direccion"));
				 al.setEmail(rs.getString("email"));
				 al.setTelefono(rs.getString("telefono"));
				 
				 alumnos.add(al);
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
		return alumnos;
	}

	
	@Override
	public int eliminar(int legajo) {
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			
			cn.AbrirConexion();

			String query = "update alumnos set estado = 0 where legajo = "+legajo;
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
		
	}

	@Override
	public Alumno obtenerUno(int legajo) {
		Conexion cn = new Conexion();
		cn.AbrirConexion();
		Alumno al = new Alumno();
		Nacionalidad nac = new Nacionalidad();
		Provincia prov = new Provincia();
		try
		 {
			 ResultSet rs= cn.query("SELECT alu.*, nac.Nombre as nombreNac, prov.Nombre as nombreProv FROM alumnos alu inner join nacionalidades nac on alu.ID_Nacionalidad = nac.id inner join provincias prov on alu.ID_Provincia = prov.id where alu.estado != 0 and alu.legajo like \"%"+legajo+"%\";");
			 if(rs.next()) {
			 
			 al.setLegajo(rs.getInt("legajo"));
			 al.setDni(rs.getString("dni"));
			 al.setNombreApellido(rs.getString("nombreApellido"));
			 al.setFechaNac(rs.getString("fechaNac"));
			 
			 nac.setId(Integer.parseInt(rs.getString("ID_Nacionalidad")));
			 nac.setNombre(rs.getString("nombreNac"));
			 al.setNacionalidad(nac);
			 
			 prov.setId(Integer.parseInt(rs.getString("ID_Provincia")));
			 prov.setNombre(rs.getString("nombreProv"));
			 al.setProvincia(prov);
			 
			 al.setDireccion(rs.getString("direccion"));
			 al.setEmail(rs.getString("email"));
			 al.setTelefono(rs.getString("telefono"));
			 
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
		return al;
	}

}
