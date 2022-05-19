import static java.util.Objects.requireNonNull;

public class Prenda {

    private TipoPrenda tipoPrenda;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Trama trama;
    private Integer maximaTemperaturaTolerada;

    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrincipal, Color colorSecundario, Trama trama, Integer maximaTemperaturaTolerada){
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
        this.maximaTemperaturaTolerada = maximaTemperaturaTolerada;
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

    public Integer getMaximaTemperaturaTolerada() {
        return maximaTemperaturaTolerada;
    }
}


