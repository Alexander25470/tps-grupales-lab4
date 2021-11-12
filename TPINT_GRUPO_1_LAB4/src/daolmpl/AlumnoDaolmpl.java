package daolmpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dao.AlumnoDao;
import entidad.Alumno;
import daolmpl.Conexion;

public class AlumnoDaolmpl implements AlumnoDao {
	
	
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";
	private static String dbName = "tpintegradorlab4?useSSL=false";
	
	public AlumnoDaolmpl(){
		

		
		
	}
	
	public int agregar(Alumno alumno) {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			
			cn.AbrirConexion();

			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into Alumnos(dni, nombreApellido,FechaNac,ID_Nacionalidad, ID_Provincia, "
			+ "direccion,email,telefono)values('"+alumno.getDni()+"','"+alumno.getNombreApellido()+"','"+alumno.getFechaNac()+"',"
			+ "'"+alumno.getIdNacionalidad()+"','"+alumno.getIdProvincia()+"','"+alumno.getDireccion()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"')";
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
	}

}
