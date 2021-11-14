package daolmpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CursoDao;
import entidad.Curso;
import entidad.Docente;
import entidad.Localidad;
import entidad.Materia;
import entidad.Nacionalidad;

public class CursoDaolmpl implements CursoDao {

	public int agregar(Curso curso) {
		
		
		
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			cn.AbrirConexion();
	
			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into cursos(ID_Materia, legajo,semestre,anio)values('"+curso.getMateria().getId()+"','"+curso.getDocente().getLegajo()+"','"+curso.getSemestre()+"',"
			+ "'"+curso.getAnio()+"')";
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
	}

	@Override
	public ArrayList<Curso> obtenerTodos() {
		
		Conexion cn = new Conexion();
		ArrayList<Curso> curso = new ArrayList<Curso>();
		try
		 {
			 cn.AbrirConexion();
			 ResultSet rs= cn.query("SELECT cur.*, mat.Nombre as nombreMat, doc.nombreApellido as nombreApellidoProfesor FROM cursos cur inner join materias as mat on mat.id = cur.ID_Materia inner join docentes as doc on doc.legajo = cur.legajo;");
			 while(rs.next())
			 {
				 Curso cur = new Curso();
				 Materia mat = new Materia();
				 Docente doc = new Docente();
				 
				 cur.setId(rs.getInt("id"));
				 cur.setSemestre(rs.getInt("semestre"));
				 
				 doc.setLegajo(Integer.parseInt(rs.getString("legajo")));
				 doc.setNombreApellido(rs.getString("nombreApellidoProfesor"));
				 cur.setDocente(doc);
				 
				 mat.setId(Integer.parseInt(rs.getString("ID_Materia")));
				 mat.setNombre(rs.getString("nombreMat"));
				 cur.setMateria(mat);
				 
				 cur.setAnio(Integer.parseInt(rs.getString("anio")));
				 
				 curso.add(cur);
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
		return curso;
}
}
