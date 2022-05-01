import static java.util.Objects.requireNonNull;

public class Prenda {

    public TipoPrenda tipoPrenda;
    public Material material; //no nulo
    public Color colorPrincipal; //no nulo
    public Color colorSecundario; //puede ser nulo

    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal, Color colorSecundario){
        this.validarPrenda(tipoPrenda, material, colorPrincipal);
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
    }

    private void validarPrenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal){
        requireNonNull(tipoPrenda, "El tipo de la prenda no puede ser nulo");
        requireNonNull(material, "El material no puede ser nulo");
        requireNonNull(colorPrincipal, "El color principal no puede ser nulo");
    }

    public boolean tieneColorSecundario(){
        return this.colorSecundario == null;
    }
   }
