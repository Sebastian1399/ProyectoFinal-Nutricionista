
package proyectofinalnutricionista;

import AccesoADatos.PacienteData;
import Entidades.Paciente;


public class ProyectoFinalNutricionista {

   
    public static void main(String[] args) {
    PacienteData pd=new PacienteData();
    Paciente p1=new Paciente(1,"juan cruz", "Perez", "Olascoaga 7150", 35539000, 261209424,true);
    //pd.guardarPaciente(p1);
    
    //pd.modificarPaciente(p1);
    pd.eliminarPaciente(1);
    
    }
    
}
