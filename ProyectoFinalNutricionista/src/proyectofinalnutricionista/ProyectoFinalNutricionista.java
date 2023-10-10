
package proyectofinalnutricionista;

import AccesoADatos.ComidaData;
import AccesoADatos.DietaComidaData;
import AccesoADatos.DietaData;
import AccesoADatos.PacienteData;
import Entidades.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProyectoFinalNutricionista {

   
    public static void main(String[] args) {
    PacienteData pd=new PacienteData();
    Paciente p1=new Paciente(1,"juan cruz", "Perez", "Olascoaga 7150", 35539000, 261209424,true);
    //pd.guardarPaciente(p1);
    
    //pd.modificarPaciente(p1);
    //pd.eliminarPaciente(1);
    //pd.rehabilitarPaciente(1);
      Comida comida3=new Comida(6,550, "tallarines con salsa", "porcion de tallarines con salsa magnossss");
      Comida comida2=new Comida(3,550, "tallarines con salsa", "porcion de tallarines con salsa magno");
      Comida comida=new Comida(1,450, "tallarines con salsa", "porcion de tallarines con salsa filetto");
      ComidaData cd=new ComidaData();
      //cd.guardarComida(comida3);
//    for(Comida com:cd.listarComidas()){
//        System.out.println(com);

  
    DietaData dd=new DietaData();
    //Dieta d1=new  Dieta(13,p1, "78", LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 30), 100, 80,70, true);
    //Dieta d3=new Dieta(p1, nombre, LocalDate.MIN, LocalDate.MIN, 0, 0, 0, true)
    //Dieta d2=new Dieta(p1, "777", LocalDate.of(2023, 8, 30), LocalDate.of(2023, 10, 30), 110, 80, 110, true) ;
    Dieta d4=new  Dieta(15,p1, "78881", LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 30), 100, 80,50, true);
   // dd.guardarDieta(d4);
    //dd.modificarDieta(d1);
    //dd.eliminarDieta(13);
   // dd.rehabilitarDieta(13);
//    for(Dieta dieta:dd.listarDietas()){
//        System.out.println(dieta);
//  }
//    
//System.out.println(pd.buscarPorId(1));

   DietaComidaData dc=new DietaComidaData();
 
   
     List<Integer> idComidas = new ArrayList<>();
            idComidas.add(1); 
            //idComidas.add(3);
            idComidas.add(6);
            
    dc.agregarComidaAUnaDieta(15, idComidas);
    //dc.borrarComidasDeUnaDieta(13);
    //dc.modificarComidasDeDieta(15, idComidas);
    //dc.listarComiodasDeDietas(15, idComidas);
    
    }
}  