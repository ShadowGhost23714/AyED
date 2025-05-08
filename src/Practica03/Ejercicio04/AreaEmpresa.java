package Practica03.Ejercicio04;

public class AreaEmpresa {
    private String identificacion;
    private int tardanza;

    public AreaEmpresa(String identificacion, int tardanza) {
        this.identificacion = identificacion;
        this.tardanza = tardanza;
    }

    @Override
    public String toString() {
        return "identificacion = " + identificacion + ", tardanza = " + tardanza;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getTardanza() {
        return tardanza;
    }

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }
}
