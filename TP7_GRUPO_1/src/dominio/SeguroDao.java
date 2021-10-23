package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeguroDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup?useSSL=false";


	
	public int eliminarSeguro(int id)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "delete from usuario where id="+id;
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}

	
	public int agregarSeguro(Seguro seguro)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('"+seguro.getDescripcion()+"',"+seguro.getIdTipo()+","+seguro.getCostoContratacion()+", "+seguro.getCostoAsegurado()+");";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public ArrayList<Seguro> obtenerSeguros() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM seguros");
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setCostoContratacion(rs.getFloat("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				
				lista.add(seguroRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}

	public ArrayList<Seguro> obtenerSegurosPorTipo(int tipo) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM seguros where idTipo = "+tipo);
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setIdTipo(rs.getInt("idTipo"));
				seguroRs.setCostoContratacion(rs.getFloat("costoContratacion"));
				seguroRs.setCostoAsegurado(rs.getFloat("costoAsegurado"));
				
				lista.add(seguroRs);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	
	public Seguro obtenerUnSeguro(int id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Seguro seguro = new Seguro();
		Connection con = null;
		try{
			con = DriverManager.getConnection(host + dbName, user, pass);
			PreparedStatement miSentencia = con.prepareStatement("Select idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado from seguros where idSeguro = ?");
			miSentencia.setInt(1, id); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			seguro.setIdSeguro(resultado.getInt("idSeguro"));
			seguro.setDescripcion(resultado.getString("descripcion"));
			seguro.setIdTipo(resultado.getInt("idTipo"));
			seguro.setCostoContratacion(resultado.getFloat("costoContratacion"));
			seguro.setCostoAsegurado(resultado.getFloat("costoAsegurado"));
		    
		    con.close();
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
		finally
		{
		}
		return seguro;
	}
	
}
