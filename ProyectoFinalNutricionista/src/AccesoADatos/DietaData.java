
package AccesoADatos;

import Entidades.Dieta;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DietaData {
    
          private Connection conexion=null;
   
    public DietaData() {
    conexion=Conexion.getConexion();
   
    }
    
 public void guardarDieta(Dieta dieta) {
        try {
            String sql = "INSERT INTO dieta (idPaciente, nombre, fechaInicio, fechaFinal, pesoInicial, pesoBuscado, pesoActual, estado)"
                    + " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dieta.getPaciente().getIdPaciente());
            ps.setString(2, dieta.getNombre());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicio()));
            ps.setDate(4, Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getPesoBuscado());
            ps.setDouble(7, dieta.getPesoActual());
            ps.setBoolean(8, dieta.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dieta.setIdDieta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Dieta guardada exitosamente...");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Dieta");

        }
    }
   
public void modificarDieta(Dieta dieta) {
         try {
            String sql = "UPDATE dieta SET nombre=?, fechaInicio=?, fechaFinal=?, pesoInicial=?, pesoBuscado=?, pesoActual=? WHERE idDieta=?";
            PreparedStatement ps=conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setDate(2, Date.valueOf(dieta.getFechaInicio()));
            ps.setDate(3, Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(4, dieta.getPesoInicial());
            ps.setDouble(5, dieta.getPesoBuscado());
            ps.setDouble(6, dieta.getPesoActual());
            ps.setInt(7, dieta.getIdDieta());
            ps.executeUpdate();
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta modificada...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
        }
    }     
        
public void eliminarDieta(int id) {
        String sql = "update dieta set estado=0 where idDieta=?";
       
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta eliminada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
        }

    }
        
public void rehabilitarDieta(int id) {
        String sql = "update dieta set estado=1 where idDieta=?";
       
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta rehabilitada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
        }

    }         

        public ArrayList<Dieta> listarDietas(){
        ArrayList<Dieta> listaD=new ArrayList();
        
        String sql="SELECT * FROM dieta";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                Dieta dieta=new Dieta();
                PacienteData pd=new PacienteData();
                dieta.setPaciente(pd.buscarPorId(rs.getInt("idPaciente")));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoBuscado(rs.getDouble("pesoBuscado"));
                dieta.setPesoActual(rs.getDouble("pesoActual"));
                
                listaD.add(dieta);
              
            }
            ps.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al acceder a la tabla dieta");
           
        }
        return listaD;
    
     }
        public void actualizarPeso(int idDieta, double pesoActual){
        String sql = "update dieta SET pesoActual=? WHERE idDieta=?";
              try {
                  PreparedStatement ps=conexion.prepareStatement(sql);
                  ps.setDouble(1, pesoActual);
                  ps.setInt(2, idDieta);
                  int exito=ps.executeUpdate();
                  if(exito==1){
                  JOptionPane.showMessageDialog(null, "Peso actualizado");
                  
                  }
              } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Error de conexion");
              }
        }
        public Dieta buscarDietaPorID(int id){
                        String sql="select * from dieta where idDieta=?";
            Dieta d1=null;
        try {
            PacienteData pd=new PacienteData();
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
              Paciente paciente=pd.buscarPorId( rs.getInt("idPaciente"));
              String nombre=rs.getString("nombre");
              LocalDate fechaInicio=rs.getDate("fechaInicio").toLocalDate();
              LocalDate fechaFinal=rs.getDate("fechaFinal").toLocalDate();
              double pesoInicial=rs.getDouble("pesoInicial");
              double pesoFinal=rs.getDouble("pesoBuscado");
              double pesoActual=rs.getDouble("pesoActual");
                
              d1=new Dieta(paciente, nombre, fechaInicio, fechaFinal, pesoInicial, pesoFinal, pesoActual, true);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(d1);
          return d1; 
        }
    
}
