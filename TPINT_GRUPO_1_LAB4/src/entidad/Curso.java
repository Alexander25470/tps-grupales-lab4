package entidad;

public class Curso {
	
	private int id;
	private Materia materia;
	private Docente docente;
	private int semestre;
	private int anio;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	@Override
	public String toString() {
		String strSemestre ="";
		if(semestre == 1) {
			strSemestre = "primer semestre";
		} else if (semestre == 2) {
			strSemestre = "segundo semestre";
		} 
		return materia.getNombre() + " - " + strSemestre + " - año " + anio;
	}	
	
	
	
}
