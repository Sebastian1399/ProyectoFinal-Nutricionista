
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
            String sql = "INSERT INTO paciente (nombre, apellido, dni, telefono, domicilio)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setInt(3, paciente.getDni());
            ps.setInt(4, paciente.getTelefono());
            ps.setString(5, paciente.getDomicilio());
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
        String sql = "UPDATE paciente SET nombre=?,apellido=?,dni=?,telefono=?,domicilio=? WHERE dni=?";
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
    
}
