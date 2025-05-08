package Ejercitacion;

public class Neumatico {
    private int vueltas;
    private String compuesto;

    public Neumatico(int vueltas, String compuesto) {
        this.vueltas = vueltas;
        this.compuesto = compuesto;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public String getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(String compuesto) {
        this.compuesto = compuesto;
    }
}
