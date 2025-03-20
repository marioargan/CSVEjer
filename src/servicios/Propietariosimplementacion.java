package servicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Propietariosimplementacion {
	
	public void añadirPropietario() {
		
		for (String fila : ) {
			
		}
		
		
		
	}	
	
	public String validarDni(String dni) {
		String[] letra = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		 String numero = dni.substring(0,8);
		 int resto = Integer.parseInt(numero) % 23;
		 String letraDni = letra[resto];
		 return letraDni;
		 
		
	}  
	
	public static void generarPath() {
		Path path= Paths.get("datosIniciales.txt");
		String contenido = "matricula:fchMatriculacion:dni:fchCompra\n"
				+ "1234ATT:12-12-2019:12345678A:12-12-2019\n"
				+ "9876WWW:10-11-2021:23456789P:21-12-2023\n"
				+ "4567UOP:20-10-1998:98765432R:20:10:1999\n"
				+ "4567UPO:20-10-1996:34567891I:20:10:2003";
		
		
		try {
            // Paso 3: Abrir y escribir en el archivo
            // Si el archivo no existe, se creará automáticamente
            Files.write(path, contenido.getBytes());

            System.out.println("El contenido se ha escrito en el archivo exitosamente.");
        } catch (IOException e) {
            // Manejo de errores si ocurre un problema al escribir en el archivo
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
}
