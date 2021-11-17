package daolmpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.NotaDao;
import entidad.Alumno;
import entidad.Curso;
import entidad.Docente;
import entidad.EstadoAlumno;
import entidad.Materia;
import entidad.Nacionalidad;
import entidad.Nota;
import entidad.Provincia;

public class NotaDaoImpl implements NotaDao{

	@Override
	public ArrayList<Nota> obtenerNotasCurso(int idCurso) {
		Conexion cn = new Conexion();
		ArrayList<Nota> notas = new ArrayList<Nota>();
		try
		 {
			 cn.AbrirConexion();
			 ResultSet rs= cn.query("select * from notas where id_curso = " + idCurso);
			 while(rs.next())
			 {
				 Nota nota = new Nota();
				 Alumno ala = new Alumno(); 
				 EstadoAlumno ea = new EstadoAlumno();
				 
				 ResultSet rsAlumno = cn.query("SELECT alu.*, nac.Nombre as nombreNac, prov.Nombre as nombreProv FROM"+
				 " alumnos alu inner join nacionalidades nac on alu.ID_Nacionalidad = nac.id inner join provincias prov on"+
						 " alu.ID_Provincia = prov.id where alu.estado != 0 and alu.legajo = "+rs.getInt("legajo"));
				 if(rsAlumno.next()) {
					 Alumno al = new Alumno();
					 Nacionalidad nac = new Nacionalidad();
					 Provincia prov = new Provincia();
					 al.setLegajo(rsAlumno.getInt("legajo"));
					 al.setDni(rsAlumno.getString("dni"));
					 al.setNombreApellido(rsAlumno.getString("nombreApellido"));
					 al.setFechaNac(rsAlumno.getString("fechaNac"));
					 
					 nac.setId(Integer.parseInt(rsAlumno.getString("ID_Nacionalidad")));
					 nac.setNombre(rsAlumno.getString("nombreNac"));
					 al.setNacionalidad(nac);
					 
					 prov.setId(Integer.parseInt(rsAlumno.getString("ID_Provincia")));
					 prov.setNombre(rsAlumno.getString("nombreProv"));
					 al.setProvincia(prov);
					 
					 al.setDireccion(rsAlumno.getString("direccion"));
					 al.setEmail(rsAlumno.getString("email"));
					 al.setTelefono(rsAlumno.getString("telefono"));
					 
					 
					 
					 ea.setId(Integer.parseInt(rs.getString("estado")));
					
					 nota.setEstado(ea);
					 nota.setAlumno(al);
					 nota.setParcial1(rs.getFloat("parcial1"));
					 nota.setParcial2(rs.getFloat("parcial2"));
					 nota.setRecuperatorio1(rs.getFloat("recuperatorio1"));
					 nota.setRecuperatorio2(rs.getFloat("recuperatorio2"));
					 
					 notas.add(nota);
				 }
				 
			 }
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 cn.close();
		 }
		return notas;
	}

}
