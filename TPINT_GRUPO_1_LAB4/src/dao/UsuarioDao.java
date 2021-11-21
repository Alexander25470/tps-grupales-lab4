package dao;

import entidad.Usuario;

public interface UsuarioDao {

	public Usuario login(String usuario, String contrasenia);

}
