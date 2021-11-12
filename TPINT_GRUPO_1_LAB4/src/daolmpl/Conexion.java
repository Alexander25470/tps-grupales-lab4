package daolmpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {

	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";
	private static String dbName = "tpintegradorlab4?useSSL=false";
	
	private Connection connection;
	
	public Connection AbrirConexion()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(host+dbName, user, pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.connection;
	}
	
	public int ejecutarConsulta(String query) {
		
		int filas = 0;
		
		Statement st;
		try {
			st = connection.createStatement();
		    st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return filas;
	}
	
	public boolean close()
	{
		boolean estado=true;
		try {
			connection.close();
		}
		catch(Exception e)
		{
			estado= false;
			e.printStackTrace();
		}
		return estado;
	}
	
}
