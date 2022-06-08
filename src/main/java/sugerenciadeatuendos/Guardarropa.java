package sugerenciadeatuendos;

import com.sun.org.apache.xpath.internal.operations.Bool;
import prenda.Prenda;

import java.util.List;

public class Guardarropa {
  private Criterio criterio;
  private List<Prenda> prendas;

  public Guardarropa(Criterio criterio, List<Prenda> prendas) {
    this.criterio = criterio;
    this.prendas = prendas;
  }

  public Criterio getCriterio() {
    return criterio;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public void eliminarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }
}
