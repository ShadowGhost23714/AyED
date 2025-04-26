package Practica01.Ejercicio05;

public class Registro {
    private int max;
    private int min;
    private float prom;

    public Registro(int max, int min, float prom) {
        this.max = max;
        this.min = min;
        this.prom = prom;
    }

    @Override
    public String toString() {
        return "máximo = " + max +", mínimo = " + min + ", promedio = " + prom;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public float getProm() {
        return prom;
    }

    public void setProm(float prom) {
        this.prom = prom;
    }
}
