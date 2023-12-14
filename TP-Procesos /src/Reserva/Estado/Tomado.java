package Reserva.Estado;

import Observer.Motivo;
import Reserva.Reserva;

public class Tomado extends EstadoReserva{
	
	
	public Tomado(Reserva reserva) {
		super(reserva);
		// TODO Auto-generated constructor stub
	}

	
	public void terminar() {
		super.reserva.setEstado(new Terminado(reserva));
		super.reserva.getHabitacion().actualizarEstado();
		super.reserva.notificar(reserva, Motivo.CAMBIO_ESTADO);
	}
	
}