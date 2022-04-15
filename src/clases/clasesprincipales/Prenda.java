package clasesprincipales;

public abstract class Prenda {

    //public Categoria categoria; //no nulo
    public Material material; //no nulo
    public Color colorPrincipal; //ver si es string - no nulo
    public Color colorSecundario = Color.SIN_COLOR; //ver si es string - puede ser nulo


    public String categoriaPrenda() {
        return this.getClass().getName();
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

    public boolean tieneColorSecundario(){
        return !colorSecundario.equals(Color.SIN_COLOR);
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

   }
