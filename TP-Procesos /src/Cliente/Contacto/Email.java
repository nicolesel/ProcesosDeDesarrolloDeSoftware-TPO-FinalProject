package Cliente.Contacto;

import Reserva.Factura;

public class Email implements EstrategiaContacto {
	
	private String email;
	
	public Email(String email) {		
		this.email = email;
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
