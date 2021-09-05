package ejercicio2;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto {
	int codigoOrgSupervision;

	public int getCodigoOrgSupervision() {
		return codigoOrgSupervision;
	}

	public void setCodigoOrgSupervision(int codigoOrgSupervision) {
		this.codigoOrgSupervision = codigoOrgSupervision;
	}

	public ProductoRefrigerado() {
		super();
		this.codigoOrgSupervision = 0;
	}


	public ProductoRefrigerado(int numeroLote, LocalDate fechaCaducidad, int codigoOrgSupervision) {
		super(numeroLote, fechaCaducidad);
		this.codigoOrgSupervision = codigoOrgSupervision;
	}

	@Override
	public String toString() {
		return super.toString()+"codigoOrgSupervision=" + codigoOrgSupervision;
	}
	
}
