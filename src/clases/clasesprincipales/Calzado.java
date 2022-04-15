package clasesprincipales;

public class Calzado extends Prenda{

    public TipoCalzado tipoCalzado;

    public Calzado(Material material, Color colorPrincipal, TipoCalzado tipoCalzado) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoCalzado = tipoCalzado;
    }

    public Calzado(Material material, Color colorPrincipal, Color colorSecundario, TipoCalzado tipoCalzado) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoCalzado = tipoCalzado;
        this.colorSecundario = colorSecundario;
    }

    public String tipo(){
        return tipoCalzado.toString();
    }

}
