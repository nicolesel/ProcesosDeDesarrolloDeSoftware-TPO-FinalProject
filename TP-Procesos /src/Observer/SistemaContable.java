package Observer;

import java.util.ArrayList;
import java.util.List;

public class SistemaContable implements Observer {

	private static SistemaContable instancia;
	private List<String> actualizaciones;
   
    private SistemaContable() {
    	this.actualizaciones= new ArrayList<String>();
    }

    public static SistemaContable getInstancia() {
       
        if (instancia == null) {
            instancia = new SistemaContable();
        }
      
        return instancia;
    }

	
	@Override
	public void actualizar(Sujeto sujeto, Motivo motivo) {
		actualizaciones.add(sujeto.getClass().getName() +"-->"+ motivo.getClass().getName());

	}

}
