package sugerenciadeatuendos;

import prenda.Prenda;

public class Agregar implements Propuesta{
  private Prenda prenda;
  private Guardarropa guardarropa;

  public Agregar(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  @Override
  public void aplicarEn(Usuario usuario) {
    usuario.agregarPrendaEnGuardarropa(guardarropa, prenda);
  }

  public Guardarropa getGuardarropa() {
    return guardarropa;
  }
}
