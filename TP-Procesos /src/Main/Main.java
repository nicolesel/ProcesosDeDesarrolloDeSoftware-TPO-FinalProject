package Main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Cliente.Cliente;
import Habitacion.Habitacion;
import Hotel.ModuloHotel;
import Reserva.Estado.Cancelado;
import Reserva.Estado.Pagado;
import Reserva.Estado.Terminado;
import Reserva.Estado.Tomado;

public class Main {
	
	public static void main(String[] args) {
	
	//acordar de hacer calendario
	
		new CrearDatosFalsos();
		//crearCliente();
		//logear();
		//cargarHabitacion();
		//buscarHabitacion();
		//reservar();
		//pagar();
		//cancelar();
		//generarReporteHabitaciones();
		//agregarHuesped();
		
	}
	

	public static void crearCliente() {
		String nombre= "";
		String apellido="";
		int dni=0;
		int telefono=0;
		String email="";
		String usuario ="";
		String contraseña="";
		String contactoEstrategia=""; //EMAIL/SMS/WPP
		
		System.out.println("Cliente creado con exito! Su ID es: "+ ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, contactoEstrategia));

	}
	
	private static void logear() {
		
		String usuario="";
		String contraseña="";
		Cliente c= ModuloHotel.getInstancia().loguear(usuario,contraseña);
		if(c!= null) {
			System.out.println("Datos Usuario Id: "+c.getId()+ " Usuario: "+c.getUsuario());
		}
		else {
			System.out.println("No existe ese cliente.");
		}
		
	}
	
	private static void cargarHabitacion() {
		
		int capacidad = 0;
        float precio = 0;
        String tipo = ""; //normal o suite
        //DEBE PONER TRUE O FALSE EN LOS EXTRAS QUE POSEA LA HABITACION
        boolean despertador = false;
        boolean internet = false;
        boolean miniBar = false;
        boolean TV = false;
        List<Boolean> lista = new ArrayList<Boolean>();
        lista.add(despertador);
        lista.add(internet);
        lista.add(miniBar);
        lista.add(TV);
 
        System.out.println("La habitacion se creo con exito! El ID es: "+ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista));
		
	}
	
	
	

	private static void buscarHabitacion() {
		
		Date fechaIn = new Date(2023,9,10);
		Date fechaOut = new Date(2023,9,11);
		int capacidad=1;
		float precioMaximo=100000;
		String tipo="normal"; //normal o suite
		//aca debe decidir cual de los extras desea que tenga si o si
		boolean despertador = false;
		boolean internet = false;
		boolean miniBar = false;
		boolean TV = false;
		List<Boolean> lista = new ArrayList<Boolean>();
		lista.add(despertador);
		lista.add(internet);
		lista.add(miniBar);
		lista.add(TV);

		List<Habitacion> listaHabitaciones = ModuloHotel.getInstancia().buscarHabitaciones(fechaIn, fechaOut, capacidad, precioMaximo, tipo, lista); //podria devolver el id de las habitaciones
		for(Habitacion h:listaHabitaciones) {
			System.out.println("Id: "+ h.getId()+" Capacidad: "+h.getCapacidad()+" Precio: "+h.getPrecio()+" Tipo: "+h.getTipo());
		}
	}
	
	private static void reservar() {
		Date fechaIn = null;
    	Date fechaOut = null;
    	int idCliente=0;
    	Cliente cliente= ModuloHotel.getInstancia().buscarCliente(idCliente);
		int capacidad=0;
		float precioMaximo=0;
		String tipo=""; //normal o suite
		//aca debe decidir cual de los extras desea que tenga si o si
		boolean despertador = false;
		boolean internet = false;
		boolean miniBar = false;
		boolean TV = false;
		List<Boolean> lista = new ArrayList<Boolean>();
		lista.add(despertador);
		lista.add(internet);
		lista.add(miniBar);
		lista.add(TV);
		List<Habitacion> habitaciones = ModuloHotel.getInstancia().buscarHabitaciones(fechaIn, fechaOut, capacidad, precioMaximo, tipo, lista); 
		if(cliente!=null && !habitaciones.isEmpty()) {
			System.out.println("La reserva se creo con exito! El id es: "+ModuloHotel.getInstancia().crearReserva(fechaIn, fechaOut, cliente, habitaciones.get(0)));
		}
		else {
			System.out.println("La reserva no se creo, hubo un problem :(");
		}
    	
		
	}
	
	private static void pagar() {

		int idReserva=0;
		String medioPago= "";
		ModuloHotel.getInstancia().pagar(idReserva,medioPago);
		if(ModuloHotel.getInstancia().buscarReserva(idReserva).getEstado() instanceof Pagado) {
			System.out.println("El pago se realizo con exito!");
		}
		else {
			System.out.println("No se pudo realizar el pago");
		}
	}
	
	private static void cancelar() {

		int idReserva=0;
		ModuloHotel.getInstancia().cancelar(idReserva);
		if(ModuloHotel.getInstancia().buscarReserva(idReserva).getEstado() instanceof Cancelado) {
			System.out.println("El cancelo con exito!");
		}
		else {
			System.out.println("No se pudo cancelar");
		}
	}
	
	private static void tomar() {

		int idReserva=0;
		ModuloHotel.getInstancia().tomar(idReserva);
		if(ModuloHotel.getInstancia().buscarReserva(idReserva).getEstado() instanceof Tomado) {
			System.out.println("Se tomo la reserva con exito!");
		}
		else {
			System.out.println("No se pudo tomar la reserva");
		}
	}
	
	private static void terminar() {

		int idReserva=0;
		ModuloHotel.getInstancia().terminar(idReserva);
		if(ModuloHotel.getInstancia().buscarReserva(idReserva).getEstado() instanceof Terminado) {
			System.out.println("Se pudo terminar la reserva!");
		}
		else {
			System.out.println("No se pudo terminar");
		}
	}

	private static void generarReporteHabitaciones() {
		ModuloHotel.getInstancia().generarReporteHabitaciones();
		
	}
	
	private static void agregarHuesped() {
		
		int idReserva = 1;
		int dni= 3;
		String nombre = "njdc";
		String apellido = "hk";
		
		ModuloHotel.getInstancia().agregarHuesped(idReserva, dni, nombre, apellido);
		
		
	}

	
}


/*Date fechaIn = new Date(2023,9,10);
Date fechaOut = new Date(2023,9,11);
int capacidad=1;
float precioMaximo=100000;
String tipo="suite"; //normal o suite
//aca debe decidir cual de los extras desea que tenga si o si
boolean despertador = false;
boolean internet = false;
boolean miniBar = false;
boolean TV = false;
List<Boolean> lista = new ArrayList<Boolean>();
lista.add(despertador);
lista.add(internet);
lista.add(miniBar);
lista.add(TV);*/
