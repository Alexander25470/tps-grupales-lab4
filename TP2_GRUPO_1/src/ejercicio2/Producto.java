package ejercicio2;
import java.time.LocalDate;

public class Producto {
//	fecha de caducidad y número de lote
	private int numeroLote;
	private LocalDate fechaCaducidad;
	
	
	public int getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	public Producto() {
		this.numeroLote = 0;
		this.fechaCaducidad = LocalDate.now();
	}
	
	public Producto(int numeroLote, LocalDate fechaCaducidad) {
		this.numeroLote = numeroLote;
		this.fechaCaducidad = fechaCaducidad;
	}
	@Override
	public String toString() {
		return "Producto: numeroLote=" + numeroLote + ", fechaCaducidad=" + fechaCaducidad;
	}
	
}

