import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Clima {
  private PropiedadClima temperatura;
  private PropiedadClima humedad;
  private PropiedadClima precipitaciones;
  private PropiedadClima viento;
  private String localizacionAsociada;
  private LocalDateTime momento;

  public Clima(PropiedadClima temperatura, PropiedadClima humedad, PropiedadClima precipitaciones, PropiedadClima viento, String localizacionAsociada, LocalDateTime momento) {
    this.temperatura = temperatura;
    this.humedad = humedad;
    this.precipitaciones = precipitaciones;
    this.viento = viento;
    this.localizacionAsociada = localizacionAsociada;
    this.momento = momento;
  }

  public PropiedadClima getTemperatura() {
    return temperatura;
  }

  public PropiedadClima getHumedad() {
    return humedad;
  }

  public PropiedadClima getPrecipitaciones() {
    return precipitaciones;
  }

  public PropiedadClima getViento() {
    return viento;
  }

  public String getLocalizacionAsociada() {
    return localizacionAsociada;
  }

  public LocalDateTime getMomento() {
    return momento;
  }
}
