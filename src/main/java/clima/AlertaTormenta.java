package clima;

public class AlertaTormenta implements AlertaService{
  @Override
  public String informar() {
    return "Alerta de Tormenta, lleva un Paraguas";
  }
}
