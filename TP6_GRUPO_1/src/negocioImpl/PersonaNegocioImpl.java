package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona) {
		boolean estado=false;
		if(!persona.getDni().isEmpty() )//Tambi�n se puede preguntar si existe ese ID 
		{
			estado=pdao.delete(persona);
		}
		return estado;
	}

	@Override
	public ArrayList<Persona> readAll() {
		return (ArrayList<Persona>)pdao.readAll();
	}

}
