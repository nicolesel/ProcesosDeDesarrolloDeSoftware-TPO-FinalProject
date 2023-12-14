package Habitacion.Extras;

public abstract class Extra {
    private float precio;
    private int numero;
    
    public Extra (float precio, int  numero) {
    	this.precio= precio;
    	this.numero= numero;
    }

    public float obtenerPrecio() {
        return precio;
    }
    
    public int getNumero() {
    	return this.numero;
    }
}
