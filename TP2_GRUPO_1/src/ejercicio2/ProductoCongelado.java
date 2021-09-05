package ejercicio2;

import java.time.LocalDate;

public class ProductoCongelado extends Producto {
	float temperaturaRecomendada;

	public float getTemperaturaRecomendada() {
		return temperaturaRecomendada;
	}

	public void setTemperaturaRecomendada(float temperaturaRecomendada) {
		this.temperaturaRecomendada = temperaturaRecomendada;
	}
	
	public ProductoCongelado() {
		super();
		this.temperaturaRecomendada = 0;
	}


	public ProductoCongelado(int numeroLote, LocalDate fechaCaducidad, float temperaturaRecomendada) {
		super(numeroLote, fechaCaducidad);
		this.temperaturaRecomendada = temperaturaRecomendada;
	}
	
	@Override
	public String toString() {
		return super.toString()+"temperaturaRecomendada=" + temperaturaRecomendada;
	}
	
}
