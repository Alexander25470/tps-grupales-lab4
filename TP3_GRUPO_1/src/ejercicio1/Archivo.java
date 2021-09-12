package ejercicio1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
	private String ruta;

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public boolean creaArchivo()
	{
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}
	
	public String leerArchivo() {
		FileReader entrada;
		String texto = "";
		try {
			entrada = new FileReader(ruta);
			int c = entrada.read(); //Lee el primer caracter
			while (c != -1) 
			{
				char letra = (char) c;
				texto+= letra;
				c = entrada.read();
			}
			entrada.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}
	
	public void escribeLineas(String frase) {
		try 
		{	
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase+"\n");
			miBuffer.close();
			entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> lee_lineas() {
		FileReader entrada;
		ArrayList<String> lineas = new ArrayList<String>();
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
		   String linea = "";
			while (linea != null) {
				if(linea !="" && linea != null) {					
					lineas.add(linea);
				}
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
			
		} catch (IOException e) {
			System.out.println("No se encontro el archivo");
		}
		return lineas;
	}
}
