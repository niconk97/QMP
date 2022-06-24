package sugerenciadeatuendos;

import java.util.List;

public class AccionNotificacionAlertas implements AccionDeAlerta{

  @Override
  public void realizarAccionPorAlerta(List<AlertaMeteorologica> alertasMeteorologicas) {
    if(alertasMeteorologicas.contains(AlertaMeteorologica.TORMENTA)) {
      new NotificationService().notify("Alerta de Tormenta, lleva un Paraguas");
    }else if (alertasMeteorologicas.contains(AlertaMeteorologica.GRANIZO)) {
      new NotificationService().notify("Alerta de Granizo, evitar salir en auto");
    }
  }
}
