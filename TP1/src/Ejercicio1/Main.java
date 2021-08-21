package Ejercicio1;

//import Dominio.Empleado;

public class Main {

	public static void main(String[] args) {
		
		Empleado[] emp1 = new Empleado[4];
		emp1[0] = new Empleado("Franco",22);
		emp1[1] = new Empleado("Cesar",32);
		emp1[2] = new Empleado("Sofia",25);
		emp1[3] = new Empleado("Mariana",20);
		
		
		for (Empleado empleado : emp1) {
			System.out.println(empleado.toString());
		}
		System.out.println(Empleado.devuelveProximoID());
		
	}

}
