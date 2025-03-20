package servicios;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz {
	
	@Override
	public void menuPrincipal() {
		System.out.println("=============");
		System.out.println("1.Propietarios");
		System.out.println("2.Vehiculos");
		System.out.println("3.Cerrar menú");
		System.out.println("=============");
	}
	
	@Override
	public void propietarios() {
		
		System.out.println("=============");
		System.out.println("1.Añadir Propietario");
		System.out.println("2.Listar Propietarios");
		System.out.println("3.Borrar Propietarios");
		System.out.println("4.Mostrar Todos Los Propietarios");
		System.out.println("5.Volver al menu principal");
		System.out.println("=============");
		
		switch (Inicio.opcionusuario=Inicio.sc.nextByte()) {
		case 1: {
			
			break;
		}
		case 2:{
			
			break;
		}
		case 3:{
			
			break;
		}
		case 4:{
			
			break;
		}
		case 5:{
			
			break;
		}

		default:
			System.out.println("La opcion elegida no existe");
		}
	}
	
	
	@Override
	public void vehiculos() {
		
		System.out.println("=============");
		System.out.println("1.Añadir Vehiculo");
		System.out.println("2.Listar Vehiculos");
		System.out.println("3.Borrar Vehiculos");
		System.out.println("4.Mostrar todos los vehiculos");
		System.out.println("5.Volver al menu principal");
		System.out.println("=============");
		
		switch (Inicio.opcionusuario=Inicio.sc.nextByte()) {
		case 1: {
			
			break;
		}
		case 2:{
			
			break;
		}
		case 3:{
			
			break;
		}
		case 4:{
			
			break;
		}
		case 5:{
			
			break;
		}
		default:
			System.out.println("La opcion elegida no existe");
		}
	}
}
