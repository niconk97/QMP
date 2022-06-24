package sugerenciadeatuendos;

import java.util.List;

public class AccionCorreoAlerta implements AccionDeAlerta{
  private MailSender servicioMail = new MailSender();
  private Correo correo;

  public AccionCorreoAlerta(Correo correo) {
    this.correo = correo;
  }

  @Override
  public void realizarAccionPorAlerta(List<AlertaMeteorologica> alertasMeteorologicas) {
    List<String> direccionesDeCorreos = this.correo.getDirecciones();
    direccionesDeCorreos.forEach(d-> {servicioMail.send(d, "Alerta de ...");}); //enviar correo con la alerta meteorologica
  }
}
