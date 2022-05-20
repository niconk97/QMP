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
  private List<PropiedadClima> consultasAnteriores = new ArrayList<>(); //Se guardan las condiciones para no consultar constantemente al servicio
  private LocalDateTime momentoDeUltimaRespuesta;

  public GestorClima() {
    this.servicioClima = new AccuWeatherAPIAdapter();
  }

  public GestorClima(ServicioClima servicioClima) {
    this.servicioClima = servicioClima;
  }

  public PropiedadClima porcentajePrecipitacionDeLocalizacion(String localizacion){
    return this.servicioClima.porcentajePrecipitacionDeLocalizacion(localizacion);
  }

  public PropiedadClima temperaturaDeLocalizacion(String localizacion){
    return this.servicioClima.temperaturaDeLocalizacion(localizacion);
  }

  public List<PropiedadClima> consultarCondicionesClimaticas(String localizacion, LocalDateTime momento){
    if(pasaronMasDeDoceHoras(momento)){
      nuevaConsulta(localizacion);
    }else{
      List<PropiedadClima> condicionesCercanasAlMomentoDado = filtrarPorMomento(this.consultasAnteriores, momento);
      List<PropiedadClima> condicionesDeLocalizacion = filtrarPorLocalizacion(condicionesCercanasAlMomentoDado, localizacion);
      return condicionesDeLocalizacion;
    }

  }

  private Boolean pasaronMasDeDoceHoras(LocalDateTime momento) {
    return true; // validar tempo que paso
  }

  private List<PropiedadClima> filtrarPorMomento(List<PropiedadClima> consultas, LocalDateTime momento) {
    return consultas.stream().filter(consulta -> consulta.getMomento().isEqual(momento)).collect(Collectors.toList());
  }

  private List<PropiedadClima> filtrarPorLocalizacion(List<PropiedadClima> consultas, String localizacion) {
    return consultas.stream().filter(consulta -> consulta.getLocalizacionAsociada().equals(localizacion)).collect(Collectors.toList());
  }

  public List<PropiedadClima> nuevaConsulta(String localizacion){
    PropiedadClima precipitaciones = porcentajePrecipitacionDeLocalizacion(localizacion);
    PropiedadClima temperatura = temperaturaDeLocalizacion(localizacion);
    consultasAnteriores.add(precipitaciones);
    consultasAnteriores.add(temperatura);
    this.momentoDeUltimaRespuesta = temperatura.getMomento();
    return consultarCondicionesClimaticas(localizacion, temperatura.getMomento());
  }


}
