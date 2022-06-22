package clima;

public class AlertaGranizo implements AlertaService{
  @Override
  public String informar() {
    return "Alerta de Granizo, evitar salir en auto";
  }
}
