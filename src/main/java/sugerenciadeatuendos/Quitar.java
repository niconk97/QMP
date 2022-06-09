package sugerenciadeatuendos;

import prenda.Prenda;

public class Quitar extends Propuesta{
  private Prenda prenda;
  private Guardarropa guardarropa;

  public Quitar(Prenda prenda, Guardarropa guardarropa) {
    super(prenda, guardarropa);
  }

  @Override
  public void aplicarEn(Usuario usuario) {
    usuario.eliminarPrendaDelGuardarropa(guardarropa, prenda);
  }

  @Override
  public void deshacerEn(Usuario usuario) {
    Propuesta agregarPendiente = new Agregar(this.prenda, this.guardarropa);
    usuario.agregarPropuestaEnPendientes(agregarPendiente);
  }

}
