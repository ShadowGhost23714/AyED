package Practica01.Ejercicio02;

public class Contador {

    public static int[] multiplos (int n) {

        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = (i + 1) * n;
        }
        return arreglo;
    }
}
