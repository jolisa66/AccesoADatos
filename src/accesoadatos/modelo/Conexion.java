
package accesoadatos.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
            String url="jdbc:mysql://localhost/prueba";
            String usuario="root";
            String password="";
            Connection con = null;

    public Conexion() {
        
        try {
            //Cargamos Drivers en memoria
            Class.forName("org..mariadb.jdbc.Driver");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        
        } 
    }
   
       public Connection getConexion() {
           //Creamos la conexion
              
try {
    
    if(null == con) {
        
    } else {
        con = DriverManager.getConnection(url + "?useLegacyDatetimeCode=falseserverTimezone=UTC" 
                + "&user=" + usuario + "&password=" + password);
        
    }
}               catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }

return con;
       }
}