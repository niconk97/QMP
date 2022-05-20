public class GestorClima {
  private ServicioClima servicioClima;

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
}
