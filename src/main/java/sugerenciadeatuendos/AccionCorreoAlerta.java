package sugerenciadeatuendos;

import java.util.List;

public class AccionCorreoAlerta implements AccionDeAlerta{
  private MailSender servicioMail = new MailSender();
  private CorreosUsuarios correos;

  public AccionCorreoAlerta(CorreosUsuarios correos) {
    this.correos = correos;
  }

  @Override
  public void realizarAccionPorAlerta(List<AlertaMeteorologica> alertasMeteorologicas) {
    List<String> direccionesDeCorreos = this.correos.getDirecciones();
    direccionesDeCorreos.forEach(d-> {servicioMail.send(d, "Alerta de ...");}); //enviar correo con la alerta meteorologica
  }
}
