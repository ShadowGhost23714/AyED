package Practica01.Ejercicio03;

public class Estudiante extends Persona{

    private String comision;
    private String direccion;

    public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
        super(nombre, apellido, email);
        this.comision = comision;
        this.direccion = direccion;
    }

    public String tusDatos() {
        String str = super.toString();
        return "Estudiante " + str + ", comision: " + comision + ", direccion: " + direccion;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
