package sugerenciadeatuendos;

import java.util.ArrayList;
import java.util.List;

public class Correo {
  List<String> direcciones = new ArrayList<>();

  public List<String> getDirecciones() {
    return direcciones;
  }

  public Correo(List<String> direcciones) {
    this.direcciones = direcciones;
  }

  public void agregarDireccionDeCorreo(String direccion){
    this.direcciones.add(direccion);
  }

  public void QuitarDireccionDeCorreo(String direccion){
    this.direcciones.remove(direccion);
  }

}
