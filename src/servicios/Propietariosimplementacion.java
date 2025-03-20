package servicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controladores.Inicio;
import dto.PropietariosDto;
import dto.VehiculosDto;

public class Propietariosimplementacion implements PropietariosInterfaz {
	
	@Override
	public void añadirPropietario() {
		
		Path path= Paths.get("datosiniciales");
		PropietariosDto propietarios = new PropietariosDto(Inicio.idAutonumerico++,null,null ,null , false);
		VehiculosDto vehiculos = new VehiculosDto();
	
		try {
			List<String> lineas = Files.readAllLines(path);
			
			for (String fila : lineas	) {
				System.out.println(fila);
			
				PropietariosDto prop = new PropietariosDto(Inicio.idAutonumerico++, fila, fila, null, false);
				VehiculosDto vehi = new VehiculosDto();
				if (fila.equals("matricula:fchMatriculacion:dni:fchCompra\n")) {
					continue;
				}
				String[] tramos = fila.split(":");
				prop.setMatricula(tramos[0]);
				vehi.setMatricula(tramos[0]);
				String fechaString = tramos[1];
				LocalDate nuevaFechaMatricula =LocalDate.parse(fechaString); 
				vehi.setFechaMatricula(nuevaFechaMatricula);
				prop.setDni(tramos[2]);
				String fechaString2=tramos[3];
				LocalDate nuevaFechaCompra= LocalDate.parse(fechaString2);
				prop.setFechaCompra(nuevaFechaCompra);
				
				LocalDate hoy= LocalDate.now();
				
				int diferencia= nuevaFechaMatricula.until(hoy).getYears();
				if (diferencia>=25) {
					prop.setEsHistorico(true);
				}
				propietarios=prop;
				vehiculos=vehi;
			}
			Inicio.propietarios.add(propietarios);
			Inicio.vehiculos.add(vehiculos);
			
		} catch (IOException e) {
			System.out.println("Error al leer el pepe" +e.getMessage());
		}
		
		
		
		
	}	
	
	public String validarDni(String dni) {
		String[] letra = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		 String numero = dni.substring(0,8);
		 int resto = Integer.parseInt(numero) % 23;
		 String letraDni = letra[resto];
		 return letraDni;
		 
		
	}
	
	@Override
	public void generarPath() {
	
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
	
	@Override
	public void listar() {
		
		for (PropietariosDto prop : Inicio.propietarios) {
			System.out.println(prop.toString());
		}
	}
}
