
package AccesoADatos;

import Entidades.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PacienteData {
    private Connection conexion=null;
   
    public PacienteData() {
    conexion=Conexion.getConexion();
   
    }
    public void guardarPaciente(Paciente paciente) {
        try {
            String sql = "INSERT INTO paciente (nombre, apellido, dni, telefono, domicilio,estado)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getDni());
            ps.setInt(4, paciente.getTelefono());
            ps.setString(5, paciente.getDomicilio());
            ps.setBoolean(6, paciente.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente guardado exitosamente...");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla Paciente");

        }
    }
    
        public void modificarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nombre=?,apellido=?,dni=?,telefono=?,domicilio=? WHERE idPaciente=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3,paciente.getDni());
            ps.setInt(4,paciente.getTelefono());
            ps.setString(5, paciente.getDomicilio());
            ps.setInt(6, paciente.getIdPaciente());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente modificado...");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla paciente");
        }
    }
    public void eliminarPaciente(int id) {
        String sql = "update paciente set estado=0 where idPaciente=?";
       
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla alumno");
        }

    }
    
        public void rehabilitarPaciente(int id) {
        String sql = "update paciente set estado=1 where idPaciente=?";
       
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente agregado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla paciente");
        }

    }
        public ArrayList<Paciente> listarPacientes(){
            String sql="select * from paciente";
           ArrayList listaP=new ArrayList();
        try {
           
            PreparedStatement ps=conexion.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String domicilio=rs.getString("domicilio");
                int dni=rs.getInt("dni");
                int telefono=rs.getInt("telefono");
                Paciente p1=new Paciente(nombre, apellido, domicilio, dni,  telefono, true);
                listaP.add(p1);
            }
           ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return listaP;
        }     
        public Paciente buscarPorId(int id){
            String sql="select * from paciente where idPaciente=?";
            Paciente p1=null;
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String domicilio=rs.getString("dni");
                int dni=rs.getInt("dni");
                int telefono=rs.getInt("telefono");
                
              p1=new Paciente(nombre, apellido, domicilio, dni, telefono, true);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return p1;  
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
