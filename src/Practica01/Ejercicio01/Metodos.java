package Practica01.Ejercicio01;

public class Metodos {

    public static void ma (int a, int b) {
        System.out.println("Método A: For");
        System.out.println("Los números entre "+a+" y "+b+" son:");
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }

    public static void mb (int a, int b) {
        System.out.println("Método B: While");
        System.out.println("Los números entre "+a+" y "+b+" son:");
        while (a<=b) {
            System.out.println(a);
            a++;
        }
    }

    public static void mc (int a, int b) {
        System.out.println("Método c:");
        System.out.println("Los números entre "+a+" y "+b+" son:");
        metodoRecurcivoC(a, b);
    }

    public static void metodoRecurcivoC (int a, int b) {
        System.out.println(a);
        if (a<b) {
            a++;
            metodoRecurcivoC(a,b);
        }
    }
}
