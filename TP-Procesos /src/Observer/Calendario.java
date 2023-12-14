package Observer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Calendario extends Sujeto {
    
    private Date hora;
    
    public Calendario() {
        iniciarConteoDias();
        programarNotificacionDiaria();
    }

    private void iniciarConteoDias() {
        // Lógica para iniciar el conteo de días (puedes implementarla según tus necesidades)
    }

    private void programarNotificacionDiaria() {
        Timer timer = new Timer();
        // Programar la tarea para que se ejecute cada día a las 7 pm
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Lógica para notificar a los observadores
            	notificar(null , Motivo.REPORTE);
            }
        }, calcularDelayHastaProxima7pm(), 24 * 60 * 60 * 1000); // Cada 24 horas
    }

    private long calcularDelayHastaProxima7pm() {
        // Lógica para calcular el tiempo hasta las 7 pm
        // Devolver el tiempo en milisegundos hasta las 7 pm del próximo día
        return calcularTiempoHastaSiguienteHora(19, 0, 0);
    }

    private long calcularTiempoHastaSiguienteHora(int hora, int minuto, int segundo) {
        // Lógica para calcular el tiempo hasta una hora específica del próximo día
        Date ahora = new Date();
        Date proximaHora = new Date(ahora.getYear(), ahora.getMonth(), ahora.getDate(), hora, minuto, segundo);
        if (proximaHora.before(ahora)) {
            proximaHora.setDate(proximaHora.getDate() + 1);
        }
        return proximaHora.getTime() - ahora.getTime();
    }

    @Override
    public void agregarObserver(Observer o) {
        super.agregarObserver(o);
    }

    @Override
    public void eliminarObserver(Observer o) {
        super.eliminarObserver(o);
    }

  
    
}
