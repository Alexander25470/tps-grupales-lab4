package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "root");
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM bdpersonas.personas;");
			rs.next();
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
