
package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
       private static final String url="jdbc:mariadb://localHost/";
    private static final String db= "proyectofinalnutricionista";
    private static final String usuario="root";
    private static final String pass="";
    private static Connection conexion;
    private Conexion(){}
    
    public static Connection getConexion(){
        if(conexion==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion=DriverManager.getConnection(url+db,usuario,pass);
            } catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(null, "error al cargar los drivers..."+ex.getMessage());
           
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "error de conexion..."+ex.getMessage());
            
            }
        }
        return conexion;
    }
}
