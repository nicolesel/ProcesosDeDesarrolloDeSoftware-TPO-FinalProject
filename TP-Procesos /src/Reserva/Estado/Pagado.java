package Reserva.Estado;

import Observer.Motivo;
import Reserva.Reserva;

public class Pagado extends EstadoReserva{
	
	
	public Pagado(Reserva reserva) {
		super(reserva);
		// TODO Auto-generated constructor stub
	}

	
	public void tomar() {
		super.reserva.setEstado(new Tomado(reserva));
		super.reserva.getHabitacion().actualizarEstado();
		super.reserva.notificar(reserva, Motivo.CAMBIO_ESTADO);
	}
	
	public void cancelar() {
		super.reserva.setEstado(new Cancelado(reserva));
		super.reserva.notificar(reserva, Motivo.CAMBIO_ESTADO);
	}
	
}
