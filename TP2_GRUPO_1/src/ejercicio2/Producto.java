package ejercicio2;
import java.util.Date;

public class Producto {
//	fecha de caducidad y número de lote
	private int numeroLote;
	private Date fechaCaducidad;
	public int getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
}
