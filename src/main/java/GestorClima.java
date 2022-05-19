public class GestorClima {
  private ServicioClima servicioClima;

  public GestorClima(ServicioClima servicioClima) {
    this.servicioClima = servicioClima;
  }

  public Integer porcentajePrecipitacionDeLocalizacion(String localizacion){
    return this.servicioClima.porcentajePrecipitacionDeLocalizacion(localizacion);
  }

  public Integer temperaturaDeLocalizacion(String localizacion){
    return this.servicioClima.temperaturaDeLocalizacion(localizacion);
  }
}
