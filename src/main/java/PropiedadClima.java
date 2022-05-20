import java.time.LocalDate;
import java.time.LocalDateTime;

public class PropiedadClima {
  private NombrePropiedad nombrePropiedad;
  private String unidad;
  private Integer valor;



  public PropiedadClima(NombrePropiedad nombrePropiedad, String unidad, Integer valor) {
    this.nombrePropiedad = nombrePropiedad;
    this.unidad = unidad;
    this.valor = valor;
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

}
