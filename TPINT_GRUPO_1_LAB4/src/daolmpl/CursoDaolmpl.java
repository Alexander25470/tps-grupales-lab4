package daolmpl;

import dao.CursoDao;
import entidad.Curso;

public class CursoDaolmpl implements CursoDao {

	public int agregar(Curso curso) {
		
		
		
		Conexion cn = new Conexion();
		int filas = 0;
		try {
			cn.AbrirConexion();
	
			//Date fechaNac = new SimpleDateFormat("yyyy/MM/dd").parse(docente.getFechaNac());  
			String query = "Insert into cursos(ID_Materia, legajo,semestre,anio)values('"+curso.getId_materia()+"','"+curso.getLegajo()+"','"+curso.getSemestre()+"',"
			+ "'"+curso.getAnio()+"')";
			filas = cn.ejecutarConsulta(query);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return filas;
	}
	
	
}
