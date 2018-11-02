
package accesoadatos;

import accesoadatos.modelo.Alumno;
import accesoadatos.modelo.AlumnoData;
import accesoadatos.modelo.Conexion;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;



public class AccesoADatos {

    //Aca arranca la aplicacion
        
        public static void main(String[] args) throws SQLException  {
        
            Alumno alumno = new Alumno("Lopez Karina", LocalDate.of(1976, Month.JANUARY, 20));
            
            Conexion con = new Conexion();
            
            //Creamos AlumnoData
            
            AlumnoData ad = new AlumnoData(con);
            
            ad.guardarAlumno(alumno);
            
            System.out.println("Nuevo Alumno id: " + alumno.getId());
            
            for(Alumno it:ad.obtenerAlumno()) {
                
                System.out.println("ID: " + it.getId());
                System.out.println("Nombre " + it.getNombre());
                
            }
            
            ad.borrarAlumno(alumno.getId());
            
            for(Alumno it:ad.obtenerAlumno()) {
                
                System.out.println("ID: " + it.getId());
                System.out.println("Nombre " + it.getNombre());
                
            }
            
            
    }
        
       
      
    }
    

