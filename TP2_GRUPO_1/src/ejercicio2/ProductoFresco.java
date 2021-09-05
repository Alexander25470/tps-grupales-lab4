package ejercicio2;

import java.time.LocalDate;

public class ProductoFresco extends Producto {
	String pais;
	LocalDate fechaEnvasado;
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public ProductoFresco() {
		super();
		pais = "Sin pais";
		fechaEnvasado = LocalDate.now();
	}
	public ProductoFresco(int numeroLote, LocalDate fechaCaducidad, String pais, LocalDate fechaEnvasado) {
		super(numeroLote, fechaCaducidad);
		this.pais = pais;
		this.fechaEnvasado = fechaEnvasado;
	}
	@Override
	public String toString() {
		return super.toString()+" pais=" + pais + ", fechaEnvasado=" + fechaEnvasado;
	}
	
}
