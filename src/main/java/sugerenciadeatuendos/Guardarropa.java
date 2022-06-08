package sugerenciadeatuendos;

import com.sun.org.apache.xpath.internal.operations.Bool;
import prenda.Prenda;

import java.util.List;

public class Guardarropa {
  private Criterio criterio;
  private List<Prenda> prendas;
  List<Usuario> usuariosDelGuardarropa;
  Boolean compartido;

  public Guardarropa(Criterio criterio, List<Prenda> prendas) {
    this.criterio = criterio;
    this.prendas = prendas;
    this.compartido = false;
  }

  public Criterio getCriterio() {
    return criterio;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public void agregarUsuario(Usuario usuario) {
    this.usuariosDelGuardarropa.add(usuario);
    if(this.usuariosDelGuardarropa.size()>1){
      this.compartido = true;
    }
  }

  public List<Usuario> getUsuariosDelGuardarropa() {
    return usuariosDelGuardarropa;
  }

  public Boolean getCompartido() {
    return compartido;
  }

  public void eliminarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }
}
