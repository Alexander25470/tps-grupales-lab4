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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antiguedadDocente;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (antiguedadDocente != other.antiguedadDocente)
			return false;
		if (this.getEdad() != other.getEdad())
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (this.getNombre() == null) {
			if (other.getNombre() != null)
				return false;
		} else if (!this.getNombre().equals(other.getNombre()))
			return false;
		return true;
	}
	
}
