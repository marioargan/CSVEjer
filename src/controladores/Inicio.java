package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.PropietariosDto;
import dto.VehiculosDto;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;

public class Inicio {
	
	public static long idAutonumerico=1;
	public static Scanner sc = new Scanner(System.in);
	public static byte opcionusuario;
	public static List<VehiculosDto> vehiculos = new ArrayList<VehiculosDto>();
	public static List<PropietariosDto> propietarios = new ArrayList<PropietariosDto>();
	
	
	
	
	public static void main(String[] args) {
		boolean cerrarMenu = false;
		MenuInterfaz menu =new MenuImplementacion();
		
		
        
		do {
			menu.menuPrincipal();
			switch (opcionusuario=sc.nextByte()) {
			
			case 1 : {
				menu.propietarios();
				break;
			}
			case 2:{
				menu.vehiculos();
				break;
			}
			case 3:{
				System.out.println("¿Deseas cerrar el menu?");
				String eleccionUsuario = sc.next();
				if(eleccionUsuario.equals("si")) {
					cerrarMenu=true;
				}
				break;
			}
			default:
				System.out.println("La opcion elegida no existe");
			}
		} while (!cerrarMenu);
	}

}
