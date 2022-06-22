package sugerenciadeatuendos;

import clima.GestorClima;

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

  public void actualizarAlertas(GestorClima gestorClima, String loc){
    gestorClima.actualizarAlertasMeteorologicas(loc);
    calcularSugerenciasDiarias();
  }

}
