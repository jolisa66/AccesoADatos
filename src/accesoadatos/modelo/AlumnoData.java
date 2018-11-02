
package accesoadatos.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlumnoData {
    
    private Connection con;

    public AlumnoData(Conexion conexion) {
       
        con = conexion.getConexion();
    
    }
    public void guardarAlumno(Alumno alumno) throws SQLException {
        
        
            String sql = "INSERT INTO alumno(nombre, fecNac, activo) VALUES(?, ?, ?);";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(3, alumno.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()) {
                alumno.setId(rs.getInt(1));
                
            } else {
            
                System.out.println("No se pudo obtener el id de alumno");
                
        } 
            
            ps.close();
         
      
}
    
    public void borrarAlumno( int id) {
        
        
        try {
            String sql = "DELETE FROM alumno WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarAlumno(Alumno alumno) {
        
        try {
            String sql = "UPDATE alumno SET nombre = ?, fecNac = ?," + "activo = ? WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setDate(2, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(3, alumno.isActivo());
            ps.setInt(4, alumno.getId());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Alumno> obtenerAlumno() {
        List<Alumno>alumnos = new ArrayList<Alumno>();
        
        try {
            
            
            String sql = "SELECT * FROM alumno WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet resultSet = ps.executeQuery();
            Alumno alumno;
            
            while(resultSet.next()) {
                
                alumno = new Alumno();
                alumno.setId(resultSet.getInt("id"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                alumno.setActivo(resultSet.getBoolean("activo"));
                
                alumnos.add(alumno);
                
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
    
    
    return alumnos;
    
    }
    
    
    public Alumno buscarAlumno(int id) throws SQLException {
    Alumno alumno=null;
                     
            
            String sql = "SELECT * FROM alumno WHERE id =?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
           
            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                alumno = new Alumno();
                alumno.setId(resultSet.getInt("id"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFecNac(resultSet.getDate("fecNac").toLocalDate());
                
            ps.setInt(1, id);
            
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecNac(rs.getDate("fecNac").toLocalDate());
                alumno.setActivo(rs.getBoolean("activo"));
                
                
            }
        }
        
        return alumno;
    }
        
    }
    