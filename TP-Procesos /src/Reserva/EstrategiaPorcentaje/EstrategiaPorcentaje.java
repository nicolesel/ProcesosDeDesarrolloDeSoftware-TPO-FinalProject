package Reserva.EstrategiaPorcentaje;

public abstract class  EstrategiaPorcentaje {
	 
	private int porcentaje;
	
	
	public EstrategiaPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getPorcentaje() {
		return this.porcentaje;
	}
}

