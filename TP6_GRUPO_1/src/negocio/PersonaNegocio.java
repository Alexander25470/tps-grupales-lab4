package negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {

	public boolean insert(Persona persona);
	public boolean delete(Persona persona);
	public boolean update(Persona persona);
	public ArrayList<Persona> readAll();
}
