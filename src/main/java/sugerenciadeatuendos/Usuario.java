package sugerenciadeatuendos;

import prenda.Prenda;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class Usuario {
  private List<Guardarropa> guardarropas;
  private List<Propuesta> propuestasPendientes;
  private List<Propuesta> propuestasAceptadas;

  public Usuario(List<Guardarropa> guardarropas) {
    this.guardarropas = guardarropas;
  }

  public void compartirGuardarropaConUsuario(Usuario usuario, Guardarropa guardarropa){
    usuario.agregarGuardarropa(guardarropa);
  }

  public void agregarGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

  public void agregarPropuestaEnPendientes(Propuesta propuesta) {
    this.propuestasPendientes.add(propuesta);
  }

  public void agregarPropuestaEnAceptadas(Propuesta propuestaAceptada){
    this.propuestasAceptadas.add(propuestaAceptada);
  }

  public List<Guardarropa> getGuardarropas() {
    return guardarropas;
  }

  public void realizarPropuestaParaPrenda(Propuesta propuesta, Usuario usuario){
    if(!usuario.ComparteGuardarropaCon(usuario,propuesta.getGuardarropa()))
      throw new NoCompartenGuardarropaException("No se puede proponer una prenda ya que no comparten el guardarropa");
    usuario.agregarPropuestaEnPendientes(propuesta);
  }

  public void efectivizarPropuesta(Propuesta propuesta){
    propuesta.aplicarEn(this);
    quitarPropuestaDePendientes(propuesta);
    agregarPropuestaEnAceptadas(propuesta);
  }

  public void rechazarPropuesta(Propuesta propuesta){
    quitarPropuestaDePendientes(propuesta);
  }

  public void deshacerPropuestaAceptada(Propuesta propuesta){
    propuesta.deshacerEn(this);
    quitarPropuestaDeAceptadas(propuesta);
  }

  private void quitarPropuestaDePendientes(Propuesta propuesta) {
    propuestasPendientes.remove(propuesta);
  }

  private void quitarPropuestaDeAceptadas(Propuesta propuesta) {
    propuestasAceptadas.remove(propuesta);
  }

  public Boolean ComparteGuardarropaCon(Usuario otroUsuario, Guardarropa guardarropa) {
    return (this.getGuardarropas().contains(guardarropa) &&  otroUsuario.getGuardarropas().contains(guardarropa));
  }

  public void eliminarPrendaDelGuardarropa(Guardarropa guardarropa, Prenda prenda) {
    Guardarropa guardarropaSeleccionado = guardarropas.stream().filter(g-> g.equals(guardarropa)).findFirst().orElse(null);
    requireNonNull(guardarropaSeleccionado, "No se encontro el guardarropa");
    guardarropaSeleccionado.eliminarPrenda(prenda);
  }

  public void agregarPrendaEnGuardarropa(Guardarropa guardarropa, Prenda prenda) {
    Guardarropa guardarropaSeleccionado = guardarropas.stream().filter(g-> g.equals(guardarropa)).findFirst().orElse(null);
    requireNonNull(guardarropaSeleccionado, "No se encontro el guardarropa");
    guardarropaSeleccionado.agregarPrenda(prenda);
  }
}
