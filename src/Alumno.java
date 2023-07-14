public class Alumno {
    String nombre;
    String carrera;
    String semestre;
    int grupo;
    double promedio;

    public Alumno(String nombre, String carrera, String semestre, int grupo, double promedio){
        this.nombre=nombre;
        this.carrera=carrera;
        this.semestre=semestre;
        this.grupo=grupo;
        this.promedio=promedio;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
}
