import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
    Prenda accesorioAleatorio = accesorios.get(ThreadLocalRandom.current().nextInt(0,accesorios.size()));
    Prenda inferiorAleatorio = inferiores.get(ThreadLocalRandom.current().nextInt(0,inferiores.size()));
    Prenda superiorAleatorio= superiores.get(ThreadLocalRandom.current().nextInt(0,superiores.size()));
    Prenda calzadoAleatorio = calzados.get(ThreadLocalRandom.current().nextInt(0,calzados.size()));
    return new Atuendo(superiorAleatorio, inferiorAleatorio, calzadoAleatorio, accesorioAleatorio);
  }


}
