
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
    
    public void guardarDietaCoimida(DietaComida dietacomida) {
        try {
            String sql = "INSERT INTO DietaComida (idDieta, idComida)"
                    + " VALUES (?,?)";
            PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dietacomida.getDieta().getIdDieta());
            ps.setInt(2, dietacomida.getComida().getIdComida());
            ps.executeUpdate();
            
            
                        ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dietacomida.setIdDietaComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "DietaComida guardada exitosamente...");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla DietaComida");

        }
        
    }
    public void modificarDieta(DietaComida dietacomida) {
         try {
            String sql = "UPDATE dieta SET idDieta=?, idComida=?  WHERE idDietaComida=?";
            PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dietacomida.getDieta().getIdDieta());
            ps.setInt(2, dietacomida.getComida().getIdComida());
            ps.executeUpdate();
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "DietaComida modificada...");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dietacomida");
        }
    }   
    
    public void eliminarDietaComida(DietaComida dietacomida) {
        String sql = "DELETE FROM dietacomida WHERE idDieta=? AND idComida= ?";
       
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dietacomida.getDieta().getIdDieta());
            ps.setInt(2, dietacomida.getComida().getIdComida());
            ps.executeUpdate();

          
             JOptionPane.showMessageDialog(null, "DietaComida eliminada");
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
        }

    }
    
        public void agregarComidaAUnaDieta(int idDieta, List<Integer> idComidas) {
        String sql = "INSERT INTO dietacomida (idDieta, idComida) VALUES (?, ?)";
        PreparedStatement ps;
           try {
            ps = conexion.prepareStatement(sql);
            for (int idComida : idComidas) {
                ps.setInt(1, idDieta);
                ps.setInt(2, idComida);
                ps.addBatch(); 
                
            JOptionPane.showMessageDialog(null, "DietaComida comida agregada");
            }
            ps.executeBatch();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
        }
        
 
        
    }
        
       public void borrarComidasDeUnaDieta(int idDieta)  {
        String sql = "DELETE FROM dietacomida WHERE idDieta = ?";
        PreparedStatement ps;
       
        try {
            
            ps = conexion.prepareStatement(sql);
                 ps.setInt(1, idDieta);
                
              JOptionPane.showMessageDialog(null, "DietaComida comida eliminda");
            
           
               } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dietacomida");
        }
        
    }     
           public void modificarComidasDeDieta(int idDieta, List<Integer> nuevaListaComidas){

        borrarComidasDeUnaDieta(idDieta);
        PreparedStatement ps;
        
        String sql = "INSERT INTO dietacomida (idDieta, idComida) VALUES (?, ?)";
        try  {
            ps = conexion.prepareStatement(sql);
            for (int idComida : nuevaListaComidas) {
                ps.setInt(1, idDieta);
                ps.setInt(2, idComida);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DietaComida comida modificada");
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
    
    

           
           
}