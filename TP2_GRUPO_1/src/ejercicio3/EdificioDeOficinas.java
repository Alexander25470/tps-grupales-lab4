package ejercicio3;

public class EdificioDeOficinas implements Edificio {
	
	double superficieEdificio;
	int numeroDeOficinas;
	
	public int getNumeroDeOficinas() {
		return numeroDeOficinas;
	}
	public void setNumeroDeOficinas(int numeroDeOficinas) {
		this.numeroDeOficinas = numeroDeOficinas;
	}
	public double getSuperficieEdificio() {
		return superficieEdificio;
	}
	public void setSuperficieEdificio(double superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
	}
	@Override
	public String toString() {
		return "EdificioDeOficinas [superficieEdificio=" + superficieEdificio + ", numeroDeOficinas=" + numeroDeOficinas
				+ "]";
	}
	public EdificioDeOficinas(double superficieEdificio, int numeroDeOficinas) {
		this.superficieEdificio = superficieEdificio;
		this.numeroDeOficinas = numeroDeOficinas;
	}
	public EdificioDeOficinas() {
		this.superficieEdificio = 0;
		this.numeroDeOficinas = 0;
	}
}
