
package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DietaComidaData {
             private Connection conexion=null;
   
    public DietaComidaData() {
    conexion=Conexion.getConexion();
   
    }
    
 
        public void agregarComidaAUnaDieta(int idDieta, List<Integer> idComidas) {
        String sql = "INSERT INTO dietacomida (idDieta, idComida) VALUES (?, ?)";
        PreparedStatement ps;
           try {
            ps = conexion.prepareStatement(sql);
            for (int idComida : idComidas) {
                ps.setInt(1, idDieta);
                ps.setInt(2, idComida);
              // ps.addBatch(); 
                 int exito=ps.executeUpdate();
             if(exito==1){JOptionPane.showMessageDialog(null, "comida agregada a la lista...");
              }    
            }
            ps.executeBatch();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
        }
        
 
        
    }
        
       public void borrarComidasDeUnaDieta(int idDieta, int idComida)  {
        String sql = "DELETE FROM dietacomida WHERE idDieta = ? AND idComida=?";
        PreparedStatement ps;
       
        try {
            
            ps = conexion.prepareStatement(sql);
                 ps.setInt(1, idDieta);
                 ps.setInt(2, idComida);
                 int exito=ps.executeUpdate();
              if(exito==1){JOptionPane.showMessageDialog(null, "comida eliminda");
              }
           
               } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dietacomida");
        }
        
    }     
     
           
    public ArrayList<DietaComida> listarComiodasDeDietas(int idDieta,List<Integer> idComidas){
        ArrayList<DietaComida> listaDC=new ArrayList();
        
        String sql="SELECT idDieta,comida.nombre  FROM dietacomida ";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                Dieta dieta=new Dieta();
                Comida comida=new Comida();                
                ps.setInt(1, idDieta);
                ps.setString(1, comida.getNombre());
                
                

            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
           
        }
        return listaDC;
    
     }  
    public List<Comida> listarDietaComida(int idDieta){
    List<Comida> listaC = new ArrayList<>();
        
        String sql="SELECT comida.idComida,comida.nombre , comida.cantCalorias , comida.detalle FROM dietacomida join comida on dietaComida.idComida=comida.idComida where idDieta=?;";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            DietaData dd=new DietaData();
            ComidaData cd=new ComidaData();
            while (rs.next()) {
                int calorias=rs.getInt("cantCalorias");
                String nombre=rs.getString("nombre");
                String detalle=rs.getString("detalle");
              
                listaC.add(new Comida(calorias,nombre,detalle));
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
           
        }
       return listaC;
    
     }
    

           
           
}