package clasesprincipales;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
    public List<Accesorio> accesorios = new ArrayList<Accesorio>(); // lista de accesorios del atuendo
    public List<PrendaSuperior> prendasSuperior = new ArrayList<PrendaSuperior>(); //lista de prendas superiores para el atuendo
    //public List<PrendaInferior> prendaInferior = new ArrayList<PrendaInferior>();// lista de prendas inferiores para el atuendo
    public PrendaInferior prendaInferior;
    public Calzado calzado;

    public List<Accesorio> getAccesorios() {
        return accesorios;
    }

    public List<PrendaSuperior> getPrendaSuperior() {
        return prendasSuperior;
    }

    public PrendaInferior getPrendaInferior() {
        return prendaInferior;
    }

    public Calzado getCalzado() {
        return calzado;
    }

    public void cargarPrendas(List<PrendaSuperior> prendasSuperior,
                              PrendaInferior prendaInferior, Calzado calzado, List<Accesorio> accesorios){

        this.accesorios = accesorios;
        this.calzado = calzado;
        this.prendaInferior = prendaInferior;
        this.prendasSuperior = prendasSuperior;

    }

    public void agregarPrendaSuperior(PrendaSuperior prendaSuperior){
        this.prendasSuperior.add(prendaSuperior);
    }

    public void agregarAccesorio(Accesorio accesorio){
        this.accesorios.add(accesorio);
    }

    public void cambiarPrendaInferior(PrendaInferior prendaInferior){
        this.prendaInferior = prendaInferior;
    }

}
