package sugerenciadeatuendos;

import prenda.Prenda;

public class Quitar implements Propuesta{
  private Prenda prenda;
  private Guardarropa guardarropa;

  public Quitar(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  @Override
  public void aplicarEn(Usuario usuario) {
    usuario.eliminarPrendaDelGuardarropa(guardarropa, prenda);
  }

  @Override
  public Guardarropa getGuardarropa() {
    return guardarropa;
  }
}
