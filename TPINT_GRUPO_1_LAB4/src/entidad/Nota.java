package entidad;

public class Nota {
	private Alumno alumno;
	private float parcial1;
	private float parcial2;
	private float recuperatorio1;
	private float recuperatorio2;
	private EstadoAlumno estado;
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public float getParcial1() {
		return parcial1;
	}
	public void setParcial1(float parcial1) {
		this.parcial1 = parcial1;
	}
	public float getParcial2() {
		return parcial2;
	}
	public void setParcial2(float parcial2) {
		this.parcial2 = parcial2;
	}
	public float getRecuperatorio1() {
		return recuperatorio1;
	}
	public void setRecuperatorio1(float recuperatorio1) {
		this.recuperatorio1 = recuperatorio1;
	}
	public float getRecuperatorio2() {
		return recuperatorio2;
	}
	public void setRecuperatorio2(float recuperatorio2) {
		this.recuperatorio2 = recuperatorio2;
	}
	public EstadoAlumno getEstado() {
		return estado;
	}
	public void setEstado(EstadoAlumno estado) {
		this.estado = estado;
	}
	
	
}
