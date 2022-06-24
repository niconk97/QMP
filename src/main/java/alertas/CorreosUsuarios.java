package alertas;

import java.util.List;

public class CorreosUsuarios {
  List<String> direcciones;

  public List<String> getDirecciones() {
    return direcciones;
  }

  public CorreosUsuarios(List<String> direcciones) {
    this.direcciones = direcciones;
  }
  /*
  public void agregarDireccionDeCorreo(String direccion){
    this.direcciones.add(direccion);
  }

  public void QuitarDireccionDeCorreo(String direccion){
    this.direcciones.remove(direccion);
  }
  */
}
