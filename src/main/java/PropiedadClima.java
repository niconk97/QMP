import java.time.LocalDate;
import java.time.LocalDateTime;

public class PropiedadClima {
  private NombrePropiedad nombrePropiedad;
  private String unidad;
  private Integer valor;
  private LocalDateTime momento;
  private String localizacionAsociada;

  public PropiedadClima(NombrePropiedad nombrePropiedad, String unidad, Integer valor, LocalDateTime momento, String localizacionAsociada) {
    this.nombrePropiedad = nombrePropiedad;
    this.unidad = unidad;
    this.valor = valor;
    this.momento = momento;
    this.localizacionAsociada = localizacionAsociada;
  }

  public NombrePropiedad getNombrePropiedad() {
    return nombrePropiedad;
  }

  public String getUnidad() {
    return unidad;
  }

  public Integer getValor() {
    return valor;
  }

  public LocalDateTime getMomento() {
    return momento;
  }

  public String getLocalizacionAsociada() {
    return localizacionAsociada;
  }
}
