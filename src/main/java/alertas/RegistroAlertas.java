package alertas;

import clima.GestorClima;

import java.util.ArrayList;
import java.util.List;

public class RegistroAlertas {

  private GestorClima gestorClima;
  private List<AlertaMeteorologica> alertasMeteorologicas = new ArrayList<>();
  private List<AccionDeAlerta> accionesDeAlertas;

  public RegistroAlertas(List<AccionDeAlerta> accionesDeAlertas, GestorClima gestorClima) {
    this.accionesDeAlertas = accionesDeAlertas;
    this.gestorClima = gestorClima;
  }

  public List<AlertaMeteorologica> enviarAlertasMeteorologicas() {
    return this.alertasMeteorologicas;
  }

  public List<AlertaMeteorologica> actualizarAlertasMeteorologicas(String localizacion) {
    List<AlertaMeteorologica> alertas = this.gestorClima.alertasDeLocalizacion(localizacion);
    ejecutarAccionesDeAlertas(alertas);
    this.alertasMeteorologicas = alertas;
    return alertas;
  }

  private void ejecutarAccionesDeAlertas(List<AlertaMeteorologica> alertasMeteorologicas) {
    this.accionesDeAlertas.forEach(a->a.realizarAccionPorAlerta(alertasMeteorologicas));
  }


  public void agregarAccion(AccionDeAlerta accion) {
    this.accionesDeAlertas.add(accion);
  }

  public void quitarAccion(AccionDeAlerta accion) {
    this.accionesDeAlertas.remove(accion);
  }
}
