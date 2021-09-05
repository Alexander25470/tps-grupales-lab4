package Ejercicio1;

public class Profesor extends Empleado implements Comparable<Profesor>{
	private String cargo;
	private int antiguedadDocente;
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public int getAntiguedadDocente() {
		return antiguedadDocente;
	}
	
	public void setAntiguedadDocente(int antiguedadDocente) {
		this.antiguedadDocente = antiguedadDocente;
	}
	
	public Profesor() {
		super();
		this.cargo = "Sin cargo";
		this.antiguedadDocente = 0;
	}
	
	public Profesor(String nombre, int edad, String cargo, int antiguedadDocente) {
		super(nombre, edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}

	public String toString() {
		return super.toString()+" cargo=" + cargo + ", antiguedadDocente=" + antiguedadDocente+"]";
	}
	@Override
	public int compareTo(Profesor o) {
	
		if(o.getId() == this.getId())
			return 0;
		
		if (o.getId()<this.getId())
		{
			return 1;
		}		
		return -1;
		
	}
}
