package sugerenciadeatuendos;

import java.util.List;

public class Correo {
  List<String> direcciones;

  public List<String> getDirecciones() {
    return direcciones;
  }

  public Correo(List<String> direcciones) {
    this.direcciones = direcciones;
  }
}
