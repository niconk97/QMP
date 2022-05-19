import static java.util.Objects.requireNonNull;

public class Borrador {
  private TipoPrenda tipoPrenda;
  private Material material; //no nulo
  private Color colorPrincipal; //no nulo
  private Color colorSecundario; //puede ser nulo
  private Trama trama = Trama.LISA;
  private Integer maximaTemperaturaTolerada;

  public Borrador(TipoPrenda tipoPrenda) {
    requireNonNull(tipoPrenda, "El tipo de la prenda no puede ser nulo");
    this.tipoPrenda = tipoPrenda;
  }

  public void especificarMaterial(Material material){
    requireNonNull(material, "El material no puede ser nulo");
    this.material = material;
  }

  public void especificarColorPrincipal(Color colorPrincipal){
    requireNonNull(colorPrincipal, "El color principal de la prenda no puede ser nulo");
    this.colorPrincipal = colorPrincipal;
  }

  public void especificarColorSecundario(Color colorSecundario){
    this.colorSecundario = colorSecundario;
  }

  public void especificarTrama(Trama trama){
    if(trama != null)
      this.trama = trama;
  }

  public void especificarMaximaTemperaturaTolerada(Integer maximaTemperaturaTolerada){
    this.maximaTemperaturaTolerada = maximaTemperaturaTolerada;
  }

  public Prenda crearPrenda(){
    return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama, maximaTemperaturaTolerada);
  }

}
