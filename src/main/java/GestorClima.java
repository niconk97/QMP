import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorClima {
  private ServicioClima servicioClima;
  private List<Clima> consultasAnteriores = new ArrayList<>(); //Se guardan los climas para no consultar constantemente al servicio
  private LocalDateTime momentoDeUltimaRespuesta;

  public GestorClima() {
    this.servicioClima = new AccuWeatherAPIAdapter();
  }

  public GestorClima(ServicioClima servicioClima) {
    this.servicioClima = servicioClima;
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
    if(pasaronMasDeDoceHoras(momentoDeUltimaRespuesta)){
      return nuevaConsulta(localizacion);
    }else{
      List<Clima> climasCercanasAlMomentoDado = filtrarPorMomento(this.consultasAnteriores, momentoDeUltimaRespuesta);
      List<Clima> climasDeLocalizacion = filtrarPorLocalizacion(climasCercanasAlMomentoDado, localizacion);
      return climasDeLocalizacion.get(0);
    }
  }

  private Boolean pasaronMasDeDoceHoras(LocalDateTime momento) {
    return true; // Faltaria validar si pasaron doce horas desde el ultimo momento que se ejecuto la consulta al servicio del clima
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


}
