package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date; 

public class DocenteDao {
	
	private String host = "jdbc:mysql://localhost:3306/tpintegradorlab4?autoReconnect=true&useSSL=false";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tpintegradorlab4";
	
	public DocenteDao(){
		

		
		
	}
	
	public int agregarDocente(Docente docente) throws ParseException {
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection cn = null;
		int filas = 0;
		try {
			cn = DriverManager.getConnection(host,user,pass);
			Statement st =	cn.createStatement();
			
			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into Docentes(dni, nombreApellido,FechaNac,ID_Nacionalidad, ID_Localidad, "
			+ "direccion,email,telefono)values('"+docente.getDni()+"','"+docente.getNombreApellido()+"','"+docente.getFechaNac()+"',"
			+ "'"+docente.getId_nacionalidad()+"','"+docente.getId_Localidad()+"','"+docente.getDireccion()+"','"+docente.getEmail()+"','"+docente.getTelefono()+"')";
			filas = st.executeUpdate(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
	}

}
