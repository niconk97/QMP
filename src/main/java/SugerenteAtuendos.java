import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenteAtuendos {

  private List<Prenda> prendas = new ArrayList<>();

  public SugerenteAtuendos(List<Prenda> prendas) {
    this.prendas = prendas;
  }

  public void sugerirAtuendo(GestorClima gestorClima, String localizacion){
    PropiedadClima temperatura = gestorClima.temperaturaDeLocalizacion(localizacion);
    List<Prenda> prendasAdecuadas = filtrarPrendasSegunTemperatura(prendas, temperatura);
    List<Prenda> prendasSuperiores = filtrarPrendasSegunCategoria(prendasAdecuadas, Categoria.PRENDA_SUPERIOR);
    List<Prenda> prendasInferiores = filtrarPrendasSegunCategoria(prendasAdecuadas, Categoria.PRENDA_INFERIOR);
    List<Prenda> calzados = filtrarPrendasSegunCategoria(prendasAdecuadas, Categoria.CALZADO);
    List<Prenda> accesorios = filtrarPrendasSegunCategoria(prendasAdecuadas, Categoria.ACCESORIO);
    armarAtuendo(prendasSuperiores, prendasInferiores, calzados, accesorios);
  }

  public List<Prenda> filtrarPrendasSegunTemperatura(List<Prenda> prendas, PropiedadClima temperatura) {
    return prendas.stream().filter(prenda -> prenda.getMaximaTemperaturaTolerada() <= temperatura.getValor()).collect(Collectors.toList());
  }

  public List<Prenda> filtrarPrendasSegunCategoria(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream().filter(prenda -> prenda.getTipoPrenda().getCategoria().equals(categoria)).collect(Collectors.toList());
  }

  public Atuendo armarAtuendo(List<Prenda> superiores, List<Prenda> inferiores, List<Prenda> calzados, List<Prenda> accesorios){
    Prenda accesorioAleatorio = accesorios.stream().findAny().orElse(null);
    Prenda inferiorAleatorio = inferiores.stream().findAny().orElse(null);
    Prenda superiorAleatorio= superiores.stream().findAny().orElse(null);;
    Prenda calzadoAleatorio = calzados.stream().findAny().orElse(null);

    validarPrendas(accesorioAleatorio, inferiorAleatorio, superiorAleatorio, calzadoAleatorio);

    return new Atuendo(superiorAleatorio, inferiorAleatorio, calzadoAleatorio, accesorioAleatorio);
  }

  private void validarPrendas(Prenda accesorioAleatorio, Prenda ... otrasPrendas) {
    List<Prenda> prendasDeAtuendo = new ArrayList<>();
    prendasDeAtuendo.add(accesorioAleatorio);
    Collections.addAll(prendasDeAtuendo, otrasPrendas);

    if(prendasDeAtuendo.contains(null)){
      throw new NoExistenPrendasParaTemperaturaActualException("No se pudo encontrar un atuendo acorde a la temperatura actual");
    }
  }
}
