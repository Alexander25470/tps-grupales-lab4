package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;

import entidad.Alumno; 

public class AlumnoDao {
	
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";
	private static String dbName = "tpintegradorlab4?useSSL=false";
	
	public AlumnoDao(){
		

		
		
	}
	
	public int agregar(Alumno alumno) {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		int filas = 0;
		try {
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st =	cn.createStatement();

			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into Alumnos(dni, nombreApellido,FechaNac,ID_Nacionalidad, ID_Provincia, "
			+ "direccion,email,telefono)values('"+alumno.getDni()+"','"+alumno.getNombreApellido()+"','"+alumno.getFechaNac()+"',"
			+ "'"+alumno.getIdNacionalidad()+"','"+alumno.getIdProvincia()+"','"+alumno.getDireccion()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"')";
			filas = st.executeUpdate(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
	}

}

