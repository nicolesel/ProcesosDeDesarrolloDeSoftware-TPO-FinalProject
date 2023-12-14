package Habitacion;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Habitacion.Extras.Despertador;
import Habitacion.Extras.Extra;
import Habitacion.Extras.Internet;
import Habitacion.Extras.MiniBar;
import Habitacion.Extras.TV;
import Reserva.Reserva;
import Reserva.Estado.Cancelado;
 
public class Habitacion {
	private List<Reserva> reservas;
    private int idHabitacion;
    private EstadoHabitacion estado;
    private int capacidad;
    private List<Extra> extra;
    private float precio;
    private Tipo tipo;
   
    public Habitacion (int contador, int capacidad,float precio,String tipo, List<Boolean> lista){
        this.idHabitacion = contador;
        this.estado = EstadoHabitacion.libre;
        this.capacidad = capacidad;
        this.tipo = corroborarTipo(tipo);
        this.extra = cargarExtras(lista);
        this.precio = getPrecioExtras() + precio;
        this.reservas= new ArrayList<Reserva>();
    }
 
    public boolean estoyLibre() {
        return this.estado.equals(EstadoHabitacion.libre);
    }
 
    public int maximaCapacidad() {
        return capacidad;
    }
 
    public void actualizarEstado() {
        if (this.estado.equals(EstadoHabitacion.libre)) {
            estado = EstadoHabitacion.ocupado;
        } else {
            estado = EstadoHabitacion.libre;
        }
    }
    
    private List<Extra> cargarExtras(List<Boolean> lista){
    	extra = new ArrayList<Extra>();
    	if (lista.get(0)) {
    		this.extra.add(new Despertador());	
    	}
    	else if (lista.get(1)) {
    		this.extra.add(new Internet());
    	}
    	else if (lista.get(2)) {
    		this.extra.add(new MiniBar());
    	}
    	else if (lista.get(3)) {
    		this.extra.add(new TV());
    	
    	}
    	return extra;
   }
 
 
 
    //getters y setters
    public boolean soyEseTipo(String tipo) {
        return this.tipo.name().equals(tipo);
    }
 
    public EstadoHabitacion getEstado() {
        return estado;
    }
 
    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }
 
    public int getCapacidad() {
        return capacidad;
    }
 
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
 
    public List<Extra> getExtra() {
        return extra;
    }
 
    public void setExtra(List<Extra> extra) {
        this.extra = extra;
    }
 
    public float getPrecio() {
        return precio;
    }
 
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public float getPrecioExtras() {
    	float suma = 0;
    	for (Extra e : extra)
    		suma += e.obtenerPrecio();
    	return suma; 
    }
 
    public Tipo getTipo() {
        return tipo;
    }
 
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
 
    public Tipo corroborarTipo(String tipo){
        if (tipo.equals(Tipo.suite.name())){
            return Tipo.suite;
        }
        return Tipo.normal;
    }

    public int getId() {
        return idHabitacion;
    }
    
    public boolean estoyDisponibleEnEsasFechas(Date fechaIn, Date fechaOut) { 
    	for (Reserva reserva : reservas) {
           
            if (fechaIn.before(reserva.getFechaOut()) && fechaOut.after(reserva.getFechaIn()) && reserva.getEstado() instanceof Cancelado) { //quiza esta mal el if
                return false; // Hay superposición, la habitación no está disponible
            }
        }
        return true; // No hay superposición, la habitación está disponible
    	
    }

	public boolean tengoExtras(List<Boolean> lista) { //si anda buenisimo, sino hay que volver a verlo
		boolean estan=true;
		if(lista.get(0)) {
			boolean ok=false;
			for(Extra e:extra) {
				if(e instanceof Despertador) {
					ok=true;
				}
			}
			if(ok=false) {
				return false;
			}
		}
		if(lista.get(1)) {
			boolean ok=false;
			for(Extra e:extra) {
				if(e instanceof Internet) {
					ok=true;
				}
			}
			if(ok=false) {
				return false;
			}
		}
		if(lista.get(2)) {
			boolean ok=false;
			for(Extra e:extra) {
				if(e instanceof MiniBar) {
					ok=true;
				}
			}
			if(ok=false) {
				return false;
			}
		}
		if(lista.get(3)) {
			boolean ok=false;
			for(Extra e:extra) {
				if(e instanceof TV) {
					ok=true;
				}
			}
			if(ok=false) {
				return false;
			}
		}
		return estan;
	}
}
