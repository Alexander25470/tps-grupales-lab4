package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import entidad.Curso;

public class CursoDao {
	

	
		
		private static String host = "jdbc:mysql://localhost:3306/";
		private static String user = "root";
		private static String pass = "root";
		private static String dbName = "tpintegradorlab4?useSSL=false";
		
		public CursoDao(){
			

			
			
		}
		
		public int agregar(Curso curso) {
			
			
			
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
				String query = "Insert into cursos(ID_Materia, legajo,semestre,anio)values('"+curso.getId_materia()+"','"+curso.getLegajo()+"','"+curso.getSemestre()+"',"
				+ "'"+curso.getAnio()+"')";
				filas = st.executeUpdate(query);
			}
			catch(Exception e){
				
				e.printStackTrace();
			}
			
			return filas;
		}

}

