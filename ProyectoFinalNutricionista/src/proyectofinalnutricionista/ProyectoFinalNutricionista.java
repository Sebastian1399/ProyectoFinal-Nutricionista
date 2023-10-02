
package proyectofinalnutricionista;

import AccesoADatos.PacienteData;
import Entidades.Paciente;


public class ProyectoFinalNutricionista {

   
    public static void main(String[] args) {
    PacienteData pd=new PacienteData();
    Paciente p1=new Paciente("juan cruz", "Perez", "Olascoaga 7150", 35539777, 261209424);
    //pd.guardarPaciente(p1);
    pd.modificarPaciente(p1);
    
    
    }
    
}
