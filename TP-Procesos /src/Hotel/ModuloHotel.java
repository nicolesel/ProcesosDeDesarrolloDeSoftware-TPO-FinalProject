package Hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Cliente.Cliente;
import Cliente.ControladorCliente;
import Habitacion.ControladorHabitaciones;
import Habitacion.Habitacion;
import Observer.Calendario;
import Observer.SistemaContable;
import Observer.SistemaMarketing;
import Reserva.ControladorReserva;
import Reserva.Huesped;
import Reserva.Reserva;

public class ModuloHotel {
	
	private static ModuloHotel instancia;
	private ControladorCliente cc;
	private ControladorHabitaciones ch;
	private ControladorReserva cr;
	private Calendario calendario;
	private SistemaContable sc;
	private SistemaMarketing sm;
	
	
	private ModuloHotel() {
		this.cc = new ControladorCliente();
		this.ch = new ControladorHabitaciones();
		this.cr = new ControladorReserva();
		this.calendario = new Calendario();
		calendario.agregarObserver(ch);
		this.sc = SistemaContable.getInstancia();
		this.sm = SistemaMarketing.getInstancia();
		
	}
	
	public static ModuloHotel getInstancia() {
		
		if (instancia == null)
			instancia = new ModuloHotel();
		return instancia;
	}
	
    public int crearReserva(Date fechaIn, Date fechaOut, Cliente cliente, Habitacion habitacion) { //falta filtrar las reservas ya hechas
        int id = this.cr.crearReserva(fechaIn, fechaOut, cliente, habitacion);
        return id;
    }
    public void cancelar(int idReserva) {
    	this.cr.cancelar(idReserva);
    }
    public void tomar(int idReserva) {
    	this.cr.tomar(idReserva);
    }
    public void pagar(int idReserva,String medio) {
    	this.cr.pagar(idReserva, medio);
    }
    public void terminar(int idReserva) {
    	this.cr.terminar(idReserva);
    }
    public void agregarHuesped(int idReserva, int dni, String nombre, String apellido) {
    	cr.agregarHuesped(idReserva,dni,nombre,apellido);
    }
    
    public int crearCliente(String nombre, String apellido, int dni, int telefono, String email, String usuario, String contraseña, String estrategia) {
    	int id = cc.crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
    	cr.generarHuesped(dni, nombre, apellido);
        return id;
    }
    public Cliente loguear(String usuario, String contrasenia) {
        return cc.loguear(usuario, contrasenia);
    }
    
    
    public int crearHabitacion(int capacidad, float precio, String tipo, List<Boolean> lista) {
       
        return ch.crearHabitacion(capacidad, precio, tipo, lista);
    }
    
    
    public Habitacion buscarHabitacion(int idHabitacion) {
        return ch.buscarHabitacion(idHabitacion);
    }

    public Cliente buscarCliente(int idCliente) {
        return cc.buscarCliente(idCliente);
    }
    
    
    public ArrayList<Habitacion> buscarHabitaciones(Date fechaIn, Date fechaOut, int capacidad, float precio , String tipo, List<Boolean> lista){
        return ch.buscarHabitaciones(fechaIn, fechaOut, capacidad,precio,tipo, lista);
    }

    public void generarReporteHabitaciones() {
        ch.actualizar(null, null);
    }
    
    public Reserva buscarReserva(int idReserva) {
    	return cr.buscarReserva(idReserva);
    }
}