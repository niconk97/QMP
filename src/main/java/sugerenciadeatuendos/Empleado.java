package sugerenciadeatuendos;

import alertas.RegistroAlertas;

import java.util.List;

public class Empleado {

  private SugerenteAtuendos sugerenteAtuendos;
  private List<Usuario> usuarios;

  public Empleado(SugerenteAtuendos sugerenteAtuendos, List<Usuario> usuarios) {
    this.sugerenteAtuendos = sugerenteAtuendos;
    this.usuarios = usuarios;
  }

  public void calcularSugerenciasDiarias(){
    usuarios.forEach(u -> u.recibirSugerencia(sugerenteAtuendos));
  }

  public void actualizarAlertas(RegistroAlertas registroAlertas, String loc){
    registroAlertas.actualizarAlertasMeteorologicas(loc);
    calcularSugerenciasDiarias();
  }
  /*
  public List<String> obtenerCorreoElectronico(List<Usuario> usuarios){
    return usuarios.stream().map(u -> u.getCorreoElectronico()).collect(Collectors.toList());
  }*/

}
