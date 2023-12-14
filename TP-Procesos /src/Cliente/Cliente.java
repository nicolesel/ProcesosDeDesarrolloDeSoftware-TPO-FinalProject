package Cliente;

import java.util.List;

import Cliente.Contacto.Email;
import Cliente.Contacto.EstrategiaContacto;
import Cliente.Contacto.SMS;
import Cliente.Contacto.WPP;
import Observer.Motivo;
import Observer.Observer;
import Observer.Sujeto;
import Reserva.Factura;
import Reserva.Reserva;

public class Cliente implements Observer {
	
	private static int contador;
	private int id;
	private String nombre;
	private String apellido;
	private int dni;
	private int telefono;
	private String email;
	private String usuario;
	private String contraseña;
	private List<Reserva> reservas;
	private EstrategiaContacto estrategia;




	public Cliente(String nombre, String apellido, int dni, int telefono, String email, String usuario, String contraseña, String estrategia) {
		this.contador ++;
		this.id = contador;
		this.nombre = nombre;         
		this.apellido = apellido;         
		this.dni = dni;         
		this.telefono = telefono;         
		this.email = email;         
		this.usuario = usuario;         
		this.contraseña = contraseña;   
		this.estrategia = buscarEstrategia(estrategia);
	}
	
	public boolean login (String usuario, String contraseña) {
		
		return false;	
	}

	
	private EstrategiaContacto buscarEstrategia (String estrategia) {
		if (estrategia.toUpperCase() == "WPP") {
			return new WPP(this.telefono);
		}
		else if (estrategia.toUpperCase() == "EMAIL") {
			return new Email(this.email);
		}
		else {
			return new SMS(this.telefono);
		}		
	}

	@Override
	public void actualizar(Sujeto sujeto, Motivo motivo) {
		if(motivo == Motivo.CAMBIO_ESTADO)
			estrategia.enviarCambio("Su reserva "+((Reserva) sujeto).getId()+" ha cambiado de estado a "+((Reserva) sujeto).getEstado().getClass().getName());
		else if(motivo == Motivo.FACTURA)
			estrategia.enviarFactura(((Reserva) sujeto).getFactura());
	}
	
	public int getId() {
		return this.id;
	}

	public EstrategiaContacto getEstrategia() {
		return this.estrategia;
	}

	public String getContraseña() {
		return contraseña;
	}


	public String getUsuario() {
		return usuario;
	}
	
	

}
