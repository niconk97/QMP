package sugerenciadeatuendos;

import prenda.Prenda;

public class Agregar extends Propuesta{
  private Prenda prenda;
  private Guardarropa guardarropa;

  public Agregar(Prenda prenda, Guardarropa guardarropa) {
    super(prenda, guardarropa);
  }

  public Prenda getPrenda() {
    return prenda;
  }

  @Override
  public void aplicarEn(Usuario usuario) {
    usuario.agregarPrendaEnGuardarropa(guardarropa, prenda);
  }

  @Override
  public void deshacerEn(Usuario usuario) {
    Propuesta quitarPendiente = new Quitar(this.prenda, this.guardarropa);
    usuario.agregarPropuestaEnPendientes(quitarPendiente);
  }

}
