package Habitacion;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Observer.Motivo;
import Observer.Observer;
import Observer.Sujeto;
 
public class ControladorHabitaciones implements Observer {
	
    private List<Habitacion> habitaciones;
    private int contador;
    
    
    public ControladorHabitaciones() {
    	this.habitaciones = new ArrayList<Habitacion>();
        this.contador = 0;
    }
 
 
    public int crearHabitacion(int capacidad, float precio, String tipo, List<Boolean> lista) {
        contador++;
        Habitacion h= new Habitacion(contador,capacidad,precio,tipo,lista);
        this.habitaciones.add(h);
        return h.getId() ;
    }
 
 
    public String generarReporteHabitacion() {
        return "Todavia no esta implementado";
    }
    
    // Agregar condicion de fechas
    public ArrayList<Habitacion> buscarHabitaciones(Date fechaIn, Date fechaOut, int capacidad, float precio , String tipo, List<Boolean> lista){
        ArrayList<Habitacion> habitacionesEncontradas = new ArrayList<Habitacion>();
 
        for (Habitacion habitacion : habitaciones) {
            // Verificar si la habitación cumple con los criterios de búsqueda
            if (habitacion.getCapacidad() >= capacidad &&
                habitacion.getPrecio() <= precio &&
                habitacion.getTipo().name() == tipo &&
                habitacion.estoyDisponibleEnEsasFechas(fechaIn,fechaOut)&&
                habitacion.tengoExtras(lista)) {
                habitacionesEncontradas.add(habitacion);
            }
        }
 
        return habitacionesEncontradas;
    }

    public Habitacion buscarHabitacion(int idHabitacion) { // no anda bien
        for (Habitacion habitacion : habitaciones) {
            if (idHabitacion == habitacion.getId()) {
                return habitacion;
            }
        }
        return null;
    }


	@Override
	public void actualizar(Sujeto sujeto, Motivo motivo) {
		List<Habitacion> reservadas = new ArrayList<Habitacion>();
		List<Habitacion> disponibles = new ArrayList<Habitacion>();
		
		for(Habitacion h:habitaciones) {
			if(h.estoyLibre())
				disponibles.add(h);
			else
				reservadas.add(h);
		}
		System.out.println("<< Imprimiendo reporte habitaciones >>");
		System.out.println("Disponibles: ");
		for(Habitacion h:disponibles) {
			System.out.print(h.getId()+" ");
		}
		System.out.println();
		System.out.println("Reservadas: ");
		for(Habitacion h:reservadas) {
			System.out.print(h.getId()+" ");
		}
		
	}
}
