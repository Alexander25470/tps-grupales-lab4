package daolmpl;


import dao.DocenteDao;
import entidad.Docente;

public class DocenteDaolmpl implements DocenteDao {	
		
	@Override
	public int agregar(Docente docente) {
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			cn.AbrirConexion();
			
			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into Docentes(dni, nombreApellido,FechaNac,ID_Nacionalidad, ID_Localidad, "
			+ "direccion,email,telefono)values('"+docente.getDni()+"','"+docente.getNombreApellido()+"','"+docente.getFechaNac()+"',"
			+ "'"+docente.getId_nacionalidad()+"','"+docente.getId_Localidad()+"','"+docente.getDireccion()+"','"+docente.getEmail()+"','"+docente.getTelefono()+"')";
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;

	}


}
