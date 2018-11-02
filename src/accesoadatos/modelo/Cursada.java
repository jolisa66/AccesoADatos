
package accesoadatos.modelo;


public class Cursada {
    
    private Alumno alumno;
    private Materia materia;
    private int nota;
    private int cursada;

    public Cursada(Alumno alumno, Materia materia, int nota, int cursada) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.cursada = cursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getCursada() {
        return cursada;
    }

    public void setCursada(int cursada) {
        this.cursada = cursada;
    }
    
    
}
