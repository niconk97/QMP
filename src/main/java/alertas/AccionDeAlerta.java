package alertas;

import java.util.List;

public interface AccionDeAlerta {
  void realizarAccionPorAlerta(List<AlertaMeteorologica> alertasMeteorologicas);
}
