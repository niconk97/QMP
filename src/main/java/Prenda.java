import static java.util.Objects.requireNonNull;

public class Prenda {

    private TipoPrenda tipoPrenda;
    private Material material; //no nulo
    private Color colorPrincipal; //no nulo
    private Color colorSecundario; //puede ser nulo
    private Trama trama;

    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal, Color colorSecundario, Trama trama){
        this.validarPrenda(tipoPrenda, material, colorPrincipal);
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
    }

    private void validarPrenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal){
        requireNonNull(tipoPrenda, "El tipo de la prenda no puede ser nulo");
        requireNonNull(material, "El material no puede ser nulo");
        requireNonNull(colorPrincipal, "El color principal no puede ser nulo");
    }

    public boolean tieneColorSecundario(){
        return this.colorSecundario == null;
    }

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public Material getMaterial() {
        return material;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public Trama getTrama() {
        return trama;
    }
}


