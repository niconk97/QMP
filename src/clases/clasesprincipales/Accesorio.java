package clasesprincipales;

public class Accesorio extends Prenda{

    public TipoAccesorio tipoAccesorio;

    public Accesorio(Material material, Color colorPrincipal, TipoAccesorio tipoAccesorio) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoAccesorio = tipoAccesorio;
    }

    public Accesorio(Material material, Color colorPrincipal, Color colorSecundario, TipoAccesorio tipoAccesorio) {
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.tipoAccesorio = tipoAccesorio;
        this.colorSecundario = colorSecundario;
    }

    public String tipo(){
        return tipoAccesorio.toString();
    }

}
