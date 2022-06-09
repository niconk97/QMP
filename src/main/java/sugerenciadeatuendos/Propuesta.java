package sugerenciadeatuendos;

import prenda.Prenda;

public abstract class Propuesta {
  private Prenda prenda;
  private Guardarropa guardarropa;

  public Prenda getPrenda() {
    return prenda;
  }

  public Guardarropa getGuardarropa() {
    return guardarropa;
  }

  public Propuesta(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }
  public abstract void aplicarEn(Usuario usuario);
  public abstract void deshacerEn(Usuario usuario);
}
