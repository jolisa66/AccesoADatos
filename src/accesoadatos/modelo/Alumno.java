
package accesoadatos.modelo;

import java.time.LocalDate;


public class Alumno {
    
    private int id;
    private String nombre;
    private LocalDate fecNac;
    private boolean activo;

    Alumno() {
       
    }

    public Alumno(String lopez_Karina, LocalDate of) {
    }


    public Alumno alumno(int id, String nombre, LocalDate fecNac, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
        return null;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
