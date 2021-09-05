package ejercicio3;

public class Polideportivo implements InstalacionDeportiva, Edificio {
	int tipoDeInstalacion;
	double superficieEdificio;
	
	public int getTipoDeInstalacion() {
		return tipoDeInstalacion;
	}
	public void setTipoDeInstalacion(int tipoDeInstalacion) {
		this.tipoDeInstalacion = tipoDeInstalacion;
	}
	public double getSuperficieEdificio() {
		return superficieEdificio;
	}
	public void setSuperficieEdificio(double superficieEdificio) {
		this.superficieEdificio = superficieEdificio;
	}
	public Polideportivo(int tipoDeInstalacion, double superficieEdificio) {
		this.tipoDeInstalacion = tipoDeInstalacion;
		this.superficieEdificio = superficieEdificio;
	}
	public Polideportivo() {
		this.tipoDeInstalacion = 0;
		this.superficieEdificio = 0;
	}
	@Override
	public String toString() {
		return "Polideportivo [tipoDeInstalacion=" + tipoDeInstalacion + ", superficieEdificio=" + superficieEdificio
				+ "]";
	}
	
}
