package ejercicio1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {			
			throw new DniInvalido();
		} catch (DniInvalido e) {
			// TODO Auto-generated catch block
			System.out.println("Caught the exception"); 
			e.printStackTrace();
		}
	}

}
