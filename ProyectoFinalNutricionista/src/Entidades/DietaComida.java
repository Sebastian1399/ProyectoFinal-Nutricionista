
package Entidades;

import java.util.*;


public class DietaComida {
    private int idDietaComida;
    private Dieta dieta;
   // private ArrayList<Comida> listaC;

    public DietaComida() {
    }

    public DietaComida(int idDietaComida, Dieta dieta) {
        this.idDietaComida = idDietaComida;
        this.dieta = dieta;
    }

    public DietaComida(Dieta dieta) {
        this.dieta = dieta;
    }

    public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    
}
