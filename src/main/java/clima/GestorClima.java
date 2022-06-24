package clima;

import sugerenciadeatuendos.AlertaMeteorologica;
import sugerenciadeatuendos.MailSender;
import sugerenciadeatuendos.NotificationService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorClima {
  private ServicioClima servicioClima;
  private List<Clima> consultasAnteriores = new ArrayList<>(); //Se guardan los climas para no consultar constantemente al servicio
  private LocalDateTime momentoDeUltimaRespuesta;
  private Integer horasDeValidez;
  private List<AlertaMeteorologica> alertasMeteorologicas = new ArrayList<>();

  public GestorClima(Integer horasDeValidez) {
    this.servicioClima = new AccuWeatherAPIAdapter();
    this.horasDeValidez = horasDeValidez;
  }

  public GestorClima(ServicioClima servicioClima, Integer horasDeValidez) {
    this.servicioClima = servicioClima;
    this.horasDeValidez = horasDeValidez;
  }

  public PropiedadClima porcentajePrecipitacionDeLocalizacion(String localizacion){
    Clima clima = this.servicioClima.condicionesDeLocalizacion(localizacion);
    return clima.getPrecipitaciones();
  }

  public PropiedadClima temperaturaDeLocalizacion(String localizacion){
    Clima clima = this.servicioClima.condicionesDeLocalizacion(localizacion);
    return clima.getTemperatura();
  }

  public Clima consultarCondicionesClimaticas(String localizacion){
    if(pasaronMasDe(this.momentoDeUltimaRespuesta, this.horasDeValidez) || this.momentoDeUltimaRespuesta == null){
      return nuevaConsulta(localizacion);
    }else{
      List<Clima> climasCercanasAlMomentoDado = filtrarPorMomento(this.consultasAnteriores, momentoDeUltimaRespuesta);
      List<Clima> climasDeLocalizacion = filtrarPorLocalizacion(climasCercanasAlMomentoDado, localizacion);
      return climasDeLocalizacion.get(0);
    }
  }

  private Boolean pasaronMasDe(LocalDateTime momento, Integer horas) {
    return true; //  Faltaria validar si se supera las horas de validez
    // desde el ultimo momento que se ejecuto la consulta al servicio del clima
  }

  private List<Clima> filtrarPorMomento(List<Clima> climas, LocalDateTime momento) {
    return climas.stream().filter(clima -> clima.getMomento().isEqual(momento)).collect(Collectors.toList());
  }

  private List<Clima> filtrarPorLocalizacion(List<Clima> climas, String localizacion) {
    return climas.stream().filter(clima -> clima.getLocalizacionAsociada().equals(localizacion)).collect(Collectors.toList());
  }

  public Clima nuevaConsulta(String localizacion){
    PropiedadClima precipitaciones = porcentajePrecipitacionDeLocalizacion(localizacion);
    PropiedadClima temperatura = temperaturaDeLocalizacion(localizacion);
    Clima clima = this.servicioClima.condicionesDeLocalizacion(localizacion);
    consultasAnteriores.add(clima);
    this.momentoDeUltimaRespuesta = clima.getMomento();
    return clima;
  }

  public List<AlertaMeteorologica> enviarAlertasMeteorologicas() {
    return this.alertasMeteorologicas;
  }

  public List<AlertaMeteorologica> actualizarAlertasMeteorologicas(String localizacion, List<String> correos) {
    List<AlertaMeteorologica> alertas = this.servicioClima.alertasDeLocalizacion(localizacion);
    ejecutarAccionesDeAlertas(alertas, correos);
    this.alertasMeteorologicas = alertas;
    return alertas;
  }

  private void ejecutarAccionesDeAlertas(List<AlertaMeteorologica> alertasMeteorologicas, List<String> correos) {
    MailSender servicioMail = new MailSender();
    correos.forEach(c-> {servicioMail.send(c, "Alerta de ...");}); //enviar correo con la alerta meteorologica
    if(alertasMeteorologicas.contains(AlertaMeteorologica.TORMENTA)) {
      new NotificationService().notify("Alerta de Tormenta, lleva un Paraguas");
    }else if (alertasMeteorologicas.contains(AlertaMeteorologica.GRANIZO)) {
      new NotificationService().notify("Alerta de Granizo, evitar salir en auto");
    }
  }

  public List<String> recibirCorreos(List<String> correos) {
    return correos;
  }
}
