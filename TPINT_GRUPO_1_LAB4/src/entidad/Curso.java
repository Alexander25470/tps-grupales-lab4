package entidad;

public class Curso {
	
	private int id;
	private int id_materia;
	private int legajo;
	private int semestre;
	private int anio;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_materia() {
		return id_materia;
	}
	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
		return "Curso [id=" + id + ", id_materia=" + id_materia + ", legajo=" + legajo + ", semestre=" + semestre
				+ ", anio=" + anio + "]";
	}
	
	
}
