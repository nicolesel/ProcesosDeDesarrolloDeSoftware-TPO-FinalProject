package Reserva.Estado;

import Observer.Motivo;
import Reserva.Reserva;

public class Pendiente extends EstadoReserva{
	
	public Pendiente(Reserva reserva) {
		super(reserva);
		// TODO Auto-generated constructor stub
	}

	public void pagar() {
		super.reserva.calcularMontoFinal();
		if(super.reserva.getMedioDePago().generarPago(super.reserva.getMontoFinal())) { //si da false, quiere decir que no se hizo el pago y no se debera hacer ni la facturo o cambiar de estado.
			super.reserva.generarFactura();
			super.reserva.notificar(reserva, Motivo.FACTURA);
			super.reserva.setEstado(new Pagado(reserva));
			super.reserva.notificar(reserva, Motivo.CAMBIO_ESTADO);
		}
	}
	
	
	public void cancelar() {
		super.reserva.setEstado(new Cancelado(reserva));
		super.reserva.notificar(reserva, Motivo.CAMBIO_ESTADO);
	}

}
