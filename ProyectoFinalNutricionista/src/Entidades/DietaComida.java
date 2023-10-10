
package Entidades;

import java.util.*;


public class DietaComida {
    private int idDietaComida;
    private Dieta dieta;
    private Comida comida;
   //private ArrayList<Comida> listaC;

    public DietaComida() {
      
    }

    public DietaComida(Dieta dieta, Comida comida) {
        this.dieta = dieta;
        this.comida = comida;
    }

    public DietaComida(int idDietaComida, Dieta dieta, Comida comida) {
        this.idDietaComida = idDietaComida;
        this.dieta = dieta;
        this.comida = comida;
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

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return "DietaComida{" + "idDietaComida=" + idDietaComida + ", dieta=" + dieta + ", comida=" + comida + '}';
    }

    
   
}