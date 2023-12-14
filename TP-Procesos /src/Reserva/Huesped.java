package Reserva;

public class Huesped {
	
	private String nombre;
	private String apellido;
	private int dni;
	
	

	public Huesped(int dni,String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}



	public int getDni() {
		
		return this.dni;
	}

}
