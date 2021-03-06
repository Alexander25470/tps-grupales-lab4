package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;


public class PersonaDaoImpl implements PersonaDao
{
	private static final String insert = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE Dni = ?";
	private static final String update = "UPDATE personas SET nombre = ? , apellido = ? WHERE Dni = ? ";
	private static final String readall = "SELECT * FROM personas";
	private static final String getOne = "SELECT * FROM personas WHERE Dni = ?";
		
	public boolean insert(Persona persona)
	{
		PreparedStatement statement;
		PreparedStatement statementPersonExists;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statementPersonExists = conexion.prepareStatement(getOne);
			statementPersonExists.setString(1,persona.getDni());
			ResultSet rs = statementPersonExists.executeQuery();
			if(!rs.next())
			{
				statement = conexion.prepareStatement(insert);
				statement.setString(1, persona.getDni());
				statement.setString(2, persona.getNombre());
				statement.setString(3, persona.getApellido());
				if(statement.executeUpdate() > 0)
				{
					conexion.commit();
					isInsertExitoso = true;
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			System.out.println("Eliminando");
			System.out.println(persona.getDni());
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<Persona> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		String dni = resultSet.getString("Dni");
		return new Persona(nombre, apellido, dni);
	}

	@Override
	public boolean update(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
}
