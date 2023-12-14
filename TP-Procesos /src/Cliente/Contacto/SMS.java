package Cliente.Contacto;

import Reserva.Factura;

public class SMS implements EstrategiaContacto {
	
	private int telefono;
	
	public SMS(int telefono) {
		
		this.telefono = telefono;
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
