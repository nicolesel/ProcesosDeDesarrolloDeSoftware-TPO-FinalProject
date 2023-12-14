package Cliente.Contacto;

import Reserva.Factura;

public interface EstrategiaContacto { // hay que seguir????
	
	void enviarFactura(Factura factura);
	void enviarCambio(String log);
}
