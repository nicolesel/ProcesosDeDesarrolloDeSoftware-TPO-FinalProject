package Observer;


import java.util.List;
import java.util.ArrayList;

public abstract class Sujeto {
	
	private List<Observer> observadores;



	public Sujeto() {
		
		this.observadores= new ArrayList<Observer>();
		
	}
	
	public void agregarObserver(Observer o) {
		
		observadores.add(o);
	}
	
	public void eliminarObserver(Observer o) {
		
		observadores.remove(o);
	}
	
	public void notificar(Sujeto sujeto, Motivo motivo) {
		
		for(Observer o:observadores){
			o.actualizar(sujeto, motivo);
		}
	}



}