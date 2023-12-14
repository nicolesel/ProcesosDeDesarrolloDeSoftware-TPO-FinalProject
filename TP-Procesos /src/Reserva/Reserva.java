package Reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Cliente.Cliente;
import Habitacion.Habitacion;
import Observer.Motivo;
import Observer.Observer;
import Observer.SistemaContable;
import Observer.SistemaMarketing;
import Observer.Sujeto;
import Reserva.Estado.EstadoReserva;
import Reserva.Estado.Pendiente;
import Reserva.EstrategiaMedioDePago.Efectivo;
import Reserva.EstrategiaMedioDePago.EstrategiaMedioDePago;
import Reserva.EstrategiaMedioDePago.MercadoPago;
import Reserva.EstrategiaMedioDePago.TarjetaCredito;
import Reserva.EstrategiaMedioDePago.TarjetaDebito;
import Reserva.EstrategiaMedioDePago.Transferencia;
import Reserva.EstrategiaPorcentaje.Aumento;
import Reserva.EstrategiaPorcentaje.Descuento;
import Reserva.EstrategiaPorcentaje.EstrategiaPorcentaje;

public class Reserva extends Sujeto implements Observer{
	private int idReserva;
	private Date fechaIn;
	private Date fechaOut;
	private Cliente cliente;
	private List<Huesped> huespedes;
	private EstadoReserva estado;
	private float montoBase;
	private float montoFinal;
	private Habitacion habitacion;
	private EstrategiaPorcentaje porcentaje;
	private EstrategiaMedioDePago medioDePago;
	private Factura factura;
	
	public Reserva(int contador, Date fechaIn, Date fechaOut, Cliente cliente, Habitacion habitacion) {
		this.idReserva = contador;
		this.fechaIn = fechaIn;
		this.fechaOut = fechaOut;
		this.cliente = cliente;
		super.agregarObserver(cliente);
		super.agregarObserver(SistemaContable.getInstancia());
		super.agregarObserver(SistemaMarketing.getInstancia());
		this.estado = new Pendiente(this);
		this.habitacion = habitacion;
		this.montoBase = calcularMontoBase();
		this.huespedes= new ArrayList<Huesped>();
	}
	
	public float calcularMontoBase() {
		return this.habitacion.getPrecio();
		
	}
	
	public void calcularMontoFinal() {
		
		calcularDescuento();
		
		if(porcentaje instanceof Descuento) {
			this.montoFinal= this.montoBase * (1-(porcentaje.getPorcentaje())/100);
		}
		else if(porcentaje instanceof Aumento) {
			this.montoFinal=  this.montoBase * (1+(porcentaje.getPorcentaje())/100);
		}
		else {
			this.montoFinal= this.montoBase;
		}
		
	}
	
    public void calcularDescuento() {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Calcular la diferencia en milisegundos
        long diferenciaEnMs = fechaIn.getTime() - fechaActual.getTime();

        // Calcular la diferencia en días
        long diferenciaEnDias = diferenciaEnMs / (1000 * 60 * 60 * 24);

        // Aplicar descuentos según la diferencia en días
        if (diferenciaEnDias <= 15) {
            this.porcentaje = new Descuento(); 
        } else if (diferenciaEnDias >= 16 && diferenciaEnDias <= 60) {
            this.porcentaje = new Aumento(); 
        }
    }
	
	public void pagar(String medioDePago) {
		definirEstrategiaPago(medioDePago);
		estado.pagar();
	}
	
	private void definirEstrategiaPago(String medioDePago) {
		medioDePago.toUpperCase();
		if(medioDePago== "EFECTIVO") 
			this.medioDePago= new Efectivo();
		else if(medioDePago== "MERCADOPAGO")
			this.medioDePago= new MercadoPago();
		else if(medioDePago== "TARJETACREDITO")
			this.medioDePago= new TarjetaCredito();
		else if(medioDePago== "TARJETADEBITO")
			this.medioDePago= new TarjetaDebito();
		else
			this.medioDePago= new Transferencia();
		
	}

	public void cancelar() {
		estado.cancelar();
	}
	
	public void tomar() {
		estado.tomar();
	}
	
	public void terminar() {
		estado.terminar();
	}
	
	public void generarFactura() {
		factura= new Factura(this.montoFinal);
	}
	
	public void agregarHuesped(Huesped huesped) {
		if (habitacion.maximaCapacidad() > huespedes.size())
			huespedes.add(huesped);
		else {
			System.out.println("No se pueden agregar mas huespedes a la reserva!");
		}
	}
	
	public boolean soyEsaReserva(int idReserva) {
		return this.idReserva==idReserva;
		
	}


	@Override
	public void actualizar(Sujeto sujeto, Motivo motivo) {
		// TODO Auto-generated method stub
		
	}
	
	public void setEstado(EstadoReserva estado) {
		this.estado= estado;
	}
	
	public EstadoReserva getEstado() {
		return this.estado;
	}

	public EstrategiaMedioDePago getMedioDePago() {
		return this.medioDePago;
	}
	
	public float getMontoFinal() {
		return this.montoFinal;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.idReserva;
	}
	public Factura getFactura() {
		return this.factura;
	}

	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public Date getFechaOut() {
		// TODO Auto-generated method stub
		return this.fechaOut;
	}
	
	
	public Date getFechaIn() {
		// TODO Auto-generated method stub
		return this.fechaIn;
	}
 
}