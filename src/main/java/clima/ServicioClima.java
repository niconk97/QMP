package clima;

import sugerenciadeatuendos.AlertaMeteorologica;

import java.util.List;

public interface ServicioClima {
   PropiedadClima porcentajePrecipitacionDeLocalizacion(String localizacion);
   PropiedadClima temperaturaDeLocalizacion(String localizacion);
   Clima condicionesDeLocalizacion(String localizacion);
   List<AlertaMeteorologica> alertasDeLocalizacion(String localizacion);
}