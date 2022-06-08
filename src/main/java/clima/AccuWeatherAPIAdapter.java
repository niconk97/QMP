package clima;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class AccuWeatherAPIAdapter implements ServicioClima{

  private AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();

  @Override
  public PropiedadClima porcentajePrecipitacionDeLocalizacion(String localizacion) {
    List<Map<String, Object>> condicionesClima = accuWeatherAPI.getWeather(localizacion);
    Integer precipitaciones = (Integer) condicionesClima.get(0).get("PrecipitationProbability");
    return new PropiedadClima(NombrePropiedad.PORCENTAJE_PRECIPITACIONES,"%",precipitaciones);
  }

  @Override
  public PropiedadClima temperaturaDeLocalizacion(String localizacion) {
    Map<String, Object> temperatura = (Map<String, Object>) accuWeatherAPI.getWeather(localizacion).get(0).get("Temperature");
    Integer valorTemperatura = (Integer) temperatura.get("Value");
    String unidadTemperatura = (String) temperatura.get("Unit");
    return new PropiedadClima(NombrePropiedad.TEMPERATURA,unidadTemperatura,valorTemperatura);
  }

  @Override
  public Clima condicionesDeLocalizacion(String localizacion) {
    PropiedadClima temperatura = temperaturaDeLocalizacion(localizacion);
    PropiedadClima precipitacion = porcentajePrecipitacionDeLocalizacion(localizacion);
    //No sabria como obtener la humedad y el viento de un clima a partir del clima.AccuWeatherAPI
    return new Clima(temperatura,null,precipitacion,null,localizacion,LocalDateTime.now());
  }


}
