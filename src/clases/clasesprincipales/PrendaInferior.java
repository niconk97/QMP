package clasesprincipales;

public class PrendaInferior extends Prenda{

    public TipoPrendaInferior tipoPrendaInferior;

    public PrendaInferior(Material material, Color colorPrincipal, TipoPrendaInferior tipoPrendaInferior) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoPrendaInferior = tipoPrendaInferior;
    }

    public PrendaInferior(Material material, Color colorPrincipal, Color colorSecundario, TipoPrendaInferior tipoPrendaInferior) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoPrendaInferior = tipoPrendaInferior;
        this.colorSecundario = colorSecundario;
    }

    public String tipo(){
        return tipoPrendaInferior.toString();
    }

}
