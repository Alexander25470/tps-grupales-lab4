package daolmpl;

import dao.AlumnoDao;
import entidad.Alumno;
import daolmpl.Conexion;

public class AlumnoDaolmpl implements AlumnoDao {
	
	public AlumnoDaolmpl(){
		

		
		
	}
	
	public int agregar(Alumno alumno) {
		
		
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			
			cn.AbrirConexion();

			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into Alumnos(dni, nombreApellido,FechaNac,ID_Nacionalidad, ID_Provincia, "
			+ "direccion,email,telefono)values('"+alumno.getDni()+"','"+alumno.getNombreApellido()+"','"+alumno.getFechaNac()+"',"
			+ "'"+alumno.getIdNacionalidad()+"','"+alumno.getIdProvincia()+"','"+alumno.getDireccion()+"','"+alumno.getEmail()+"','"+alumno.getTelefono()+"')";
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
	}

}
