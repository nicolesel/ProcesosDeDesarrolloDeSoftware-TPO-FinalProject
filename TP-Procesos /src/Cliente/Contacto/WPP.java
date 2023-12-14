package Cliente.Contacto;

import Reserva.Factura;

public class WPP implements EstrategiaContacto {
	
	private int numero;
	
	public WPP(int numero) {
		this.numero = numero;	
	}

	@Override
	public void enviarCambio(String log) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarFactura(Factura factura) {
		// TODO Auto-generated method stub
		
	}

}
