package Ejercicio1;

//import Dominio.Empleado;

public class Main {

	public static void main(String[] args) {
		
		Empleado[] emp1 = new Empleado[4];
		emp1[0] = new Empleado("Zair",20);
		emp1[1] = new Empleado("Nahuel",17);
		emp1[2] = new Empleado("Fernando",30);
		emp1[3] = new Empleado("Franco",20);
		emp1[4] = new Empleado("Alex",15);
		
		for (Empleado empleado : emp1) {
			System.out.println(empleado.toString());
		}
		System.out.println(Empleado.devuelveProximoID());
		
	}

}
