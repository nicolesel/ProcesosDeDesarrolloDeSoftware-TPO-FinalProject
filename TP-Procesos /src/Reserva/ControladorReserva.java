package Reserva;

import java.util.List;

import Cliente.Cliente;
import Habitacion.Habitacion;
import Reserva.Estado.EstadoReserva;
import Reserva.EstrategiaMedioDePago.EstrategiaMedioDePago;
import Reserva.EstrategiaPorcentaje.EstrategiaPorcentaje;

import java.util.ArrayList;
import java.util.Date;

public class ControladorReserva {
	private List<Reserva> reservas;
	private List<Huesped> huespedes;
	private int contador;
	
	public ControladorReserva() {
		this.reservas = new ArrayList<Reserva>();
		this.huespedes= new ArrayList<Huesped>();
		this.contador = 0;
	}
	
	public int crearReserva (Date fechaIn, Date fechaOut, Cliente cliente, Habitacion habitacion) {
		contador++;
		Reserva reservaNueva = new Reserva(contador, fechaIn, fechaOut, cliente, habitacion);
		reservas.add(reservaNueva);
		return contador;
	}
	
	public void cancelar (int idReserva) {
		Reserva r=buscarReserva(idReserva);
		if(r!=null) {
			r.cancelar();
		}		
	}
	
	public void tomar(int idReserva) {
		Reserva r=buscarReserva(idReserva);
		if(r!=null) {
			r.tomar();
		}	
	}
	
	public void pagar(int idReserva,String medio) {
		Reserva r=buscarReserva(idReserva);
		if(r!=null) {
			r.pagar(medio);
		}	
	}
	
	public void terminar(int idReserva) {
		Reserva r=buscarReserva(idReserva);
		if(r!=null) {
			r.terminar();
		}	
	}
	
	public void agregarHuesped(int idReserva, int dni, String nombre, String apellido) {
		if(buscarHuesped(dni)==null) {
			generarHuesped(dni,nombre,apellido);
		}
		Reserva r=buscarReserva(idReserva);
		if(r!=null) {
			r.agregarHuesped(buscarHuesped(dni));
		}		
	}
	
	public Huesped buscarHuesped(int dni) {
		for(Huesped h: huespedes) {
			if(dni==h.getDni()) {
				return h;
			}
		}
		return null;
	}

	public void generarHuesped( int dni, String nombre, String apellido) {
		
		Huesped h= new Huesped(dni,nombre,apellido);
		huespedes.add(h);
	}
	
	public Reserva buscarReserva(int idReserva) {
		for(Reserva r:reservas) {
			if(idReserva==r.getId()) {
				return r;
			}
		}
		return null;	
	}

	public Habitacion getHabitacion(int idReserva) {
		return buscarReserva(idReserva).getHabitacion();
	}

 
}
