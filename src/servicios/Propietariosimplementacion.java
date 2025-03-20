package servicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import controladores.Inicio;
import dto.PropietariosDto;
import dto.VehiculosDto;

public class Propietariosimplementacion implements PropietariosInterfaz {
	
	@Override
	public void añadirPropietario() {
		
		Path path = Paths.get("datosIniciales.txt");
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	    try {
	        if (!Files.exists(path)) {
	            System.out.println("El archivo no existe: " + path);
	            return;
	        }

	        List<String> lineas = Files.readAllLines(path);

	        if (lineas.isEmpty()) {
	            System.out.println("El archivo está vacío.");
	            return;
	        }

	        boolean primeraLinea = true;

	        for (String fila : lineas) {
	            if (primeraLinea) {
	                primeraLinea = false;
	                continue; // Saltamos la cabecera
	            }

	            System.out.println(fila);

	            String[] tramos = fila.split(":",4);

	            // Verificar que la línea tenga 4 columnas
	            if (tramos.length != 4) {
	                System.out.println("Error: línea con formato incorrecto -> " + fila);
	                continue;
	            }

	            // Validar que las fechas estén bien formateadas
	            if (!tramos[1].matches("\\d{2}-\\d{2}-\\d{4}") || !tramos[3].matches("\\d{2}-\\d{2}-\\d{4}")) {
	                System.out.println("Formato de fecha incorrecto en línea: " + fila);
	                continue;
	            }

	            // Crear objetos DTO para cada línea
	            PropietariosDto prop = new PropietariosDto(Inicio.idAutonumerico++, null, null, null, false);
	            VehiculosDto vehi = new VehiculosDto();

	            // Asignar valores
	            prop.setMatricula(tramos[0]);
	            vehi.setMatricula(tramos[0]);

	            LocalDate fechaMatricula = LocalDate.parse(tramos[1], formatter);
	            vehi.setFechaMatricula(fechaMatricula);

	            prop.setDni(tramos[2]);

	            LocalDate fechaCompra = LocalDate.parse(tramos[3], formatter);
	            prop.setFechaCompra(fechaCompra);

	            // Determinar si es histórico
	            LocalDate hoy = LocalDate.now();
	            int diferencia = fechaMatricula.until(hoy).getYears();
	            prop.setEsHistorico(diferencia >= 25);

	            // 🚀 Ahora sí agregamos los DTOs correctamente a la lista
	            Inicio.propietarios.add(prop);
	            Inicio.vehiculos.add(vehi);
	        }

	        System.out.println("Se han añadido todos los propietarios y vehículos correctamente.");

	    } catch (IOException e) {
	        System.out.println("Error al leer el archivo: " + e.getMessage());
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
