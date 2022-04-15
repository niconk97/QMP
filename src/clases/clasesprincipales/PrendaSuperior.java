package clasesprincipales;

public class PrendaSuperior extends Prenda{

    public TipoPrendaSuperior tipoPrendaSuperior;

    public PrendaSuperior(Material material, Color colorPrincipal, TipoPrendaSuperior tipoPrendaSuperior) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoPrendaSuperior = tipoPrendaSuperior;
    }

    public PrendaSuperior(Material material, Color colorPrincipal, Color colorSecundario, TipoPrendaSuperior tipoPrendaSuperior) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoPrendaSuperior = tipoPrendaSuperior;
        this.colorSecundario = colorSecundario;
    }

    public String tipo(){
        return tipoPrendaSuperior.toString();
    }

}
