package Practica02.Ejercicio09;

public class SumDif {
    private int sum;
    private int dif;

    public SumDif(int sum, int dif) {
        this.sum = sum;
        this.dif = dif;
    }

    @Override
    public String toString() {
        return "sum=" + sum + ", dif=" + dif;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }
}
