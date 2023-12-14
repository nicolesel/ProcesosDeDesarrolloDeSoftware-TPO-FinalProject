package Observer;

import java.util.ArrayList;
import java.util.List;

public class SistemaMarketing implements Observer {

	
	private static SistemaMarketing instancia;
	private List<String> actualizaciones;

	   
    private SistemaMarketing() {
    	this.actualizaciones= new ArrayList<String>();
    }

  
    public static SistemaMarketing getInstancia() {
       
        if (instancia == null) {
            instancia = new SistemaMarketing();
        }
      
        return instancia;
    }
	
	@Override
	public void actualizar(Sujeto sujeto, Motivo motivo) {
		
		actualizaciones.add(sujeto.getClass().getName() +"-->"+ motivo.getClass().getName());
	}

}
