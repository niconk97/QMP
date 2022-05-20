public interface ServicioClima {
   PropiedadClima porcentajePrecipitacionDeLocalizacion(String localizacion);
   PropiedadClima temperaturaDeLocalizacion(String localizacion);
   Clima condicionesDeLocalizacion(String localizacion);
}