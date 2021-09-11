package ejercicio1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*try {			
			Persona.verificarDniInvalido("12441981");
		} catch (DniInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Archivo ar = new Archivo();
		ar.setRuta("Personas.txt");
		ar.lee_lineas();
	}
	

}
