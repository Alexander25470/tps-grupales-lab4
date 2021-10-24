package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SeguroDao {

	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass = "root";
	private static String dbName = "segurosgroup?useSSL=false";


	
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
			String query = "INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('"+seguro.getDescripcion()+"',"+seguro.getTipoSeguro().getIdTipo()+","+seguro.getCostoContratacion()+", "+seguro.getCostoAsegurado()+");";
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
			
			ResultSet rs = st.executeQuery("SELECT s.idSeguro, s.descripcion, s.idTipo, s.costoContratacion, s.costoAsegurado, ts.descripcion as descripcionTipo FROM segurosgroup.seguros s inner join segurosgroup.tiposeguros ts on s.idTipo = ts.idTipo");
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setTipoSeguro(new TipoSeguro(rs.getInt("idTipo"),rs.getString("descripcionTipo")));
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
			
			ResultSet rs = st.executeQuery("SELECT s.idSeguro, s.descripcion, s.idTipo, s.costoContratacion, s.costoAsegurado, ts.descripcion as descripcionTipo FROM segurosgroup.seguros s inner join segurosgroup.tiposeguros ts on s.idTipo = ts.idTipo where s.idTipo = "+tipo);
			
			while(rs.next()){
				
				Seguro seguroRs = new Seguro();
				seguroRs.setIdSeguro(rs.getInt("idSeguro"));
				seguroRs.setDescripcion(rs.getString("descripcion"));
				seguroRs.setTipoSeguro(new TipoSeguro(rs.getInt("idTipo"),rs.getString("descripcionTipo")));
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
			PreparedStatement miSentencia = con.prepareStatement("SELECT s.idSeguro, s.descripcion, s.idTipo, s.costoContratacion, s.costoAsegurado, ts.descripcion as descripcionTipo FROM segurosgroup.seguros s inner join segurosgroup.tiposeguros ts on s.idTipo = ts.idTipo where idSeguro = ?");
			miSentencia.setInt(1, id); //Cargo el ID recibido
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();
			
			seguro.setIdSeguro(resultado.getInt("idSeguro"));
			seguro.setDescripcion(resultado.getString("descripcion"));
			seguro.setTipoSeguro(new TipoSeguro(resultado.getInt("idTipo"),resultado.getString("descripcionTipo")));
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
	
	
	public static int obtenerMaxId() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int id = 0;
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT max(s.idTipo)+1 as proxid FROM segurosgroup.seguros s");
			rs.next();
			id = rs.getInt("proxid");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return id;
	}
	
}
