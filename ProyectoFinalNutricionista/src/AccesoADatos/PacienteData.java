
package AccesoADatos;

import Entidades.Paciente;
import java.sql.*;
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
}
