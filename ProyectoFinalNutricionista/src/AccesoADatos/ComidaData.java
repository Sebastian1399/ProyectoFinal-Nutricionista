
package AccesoADatos;

import Entidades.Comida;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ComidaData {
    private Connection conexion;

    public ComidaData() {
    conexion=Conexion.getConexion();
    }
    public void guardarComida(Comida comida){
        String sql="INSERT INTO comida( nombre, detalle, cantCalorias) VALUES (?,?,?)";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3, comida.getCantCalorias());
            ps.executeUpdate();
            
             ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setIdComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida guardada exitosamente...");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Comida");
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void modificarComida(Comida comida){
        String sql = "UPDATE comida SET nombre=?,detalle=?,cantCalorias=?"
                + " WHERE idComida=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3,comida.getCantCalorias());
            ps.setInt(4, comida.getIdComida());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida modificada...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Comida");
        }
    }
    public void eliminarComida(Comida comida){
             String sql = "DELETE FROM comida WHERE idComida=?";
       
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, comida.getIdComida());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida eliminada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla comida");
        }
    }
    public ArrayList<Comida> listarComidas(){
        ArrayList<Comida> listaC=new ArrayList();
        
        String sql="select * from comida";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int calorias=rs.getInt("cantCalorias");
                String nombre=rs.getString("nombre");
                String detalle=rs.getString("detalle");
                Comida comida=new Comida(calorias, nombre, detalle);
                listaC.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al acceder a la tabla comida");
            Logger.getLogger(ComidaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaC;
     
    }
    public ArrayList<Comida> buscarPorCalorias   (int calorias){
        ArrayList<Comida> listaC;
        
        
        
        return listaC;  
    }
}
