package sugerenciadeatuendos;

import clima.GestorClima;

import java.util.List;
import java.util.stream.Collectors;

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

  public void actualizarAlertas(GestorClima gestorClima, String loc){
    gestorClima.actualizarAlertasMeteorologicas(loc, obtenerCorreoElectronico(usuarios));
    //gestorClima.recibirCorreos(obtenerCorreoElectronico(usuarios));
    calcularSugerenciasDiarias();
  }

  public List<String> obtenerCorreoElectronico(List<Usuario> usuarios){
    return usuarios.stream().map(u -> u.getCorreoElectronico()).collect(Collectors.toList());
  }

}
