package Practica01.Ejercicio05;

public class Calcular {
    private static Registro record;

    public static Registro MetodoA (int [] arreglo) {

        int max = -999999, min = 999999, total = 0;
        for (int i: arreglo) {
            if (i > max) {
                max = i;
            }
            else if (i < min) {
                min = i;
            }
            total += i;
        }
        return new Registro (max, min,  (float) total/ arreglo.length);
    }

    public static void MetodoB (int [] arreglo, Registro registro) {

        int max = -999999, min = 999999, total = 0;
        for (int i: arreglo) {
            if (i > max) {
                max = i;
            }
            else if (i < min) {
                min = i;
            }
            total += i;
        }
        registro.setMax(max);
        registro.setMin(min);
        registro.setProm( (float) total/ arreglo.length);
    }

    public static void MetodoC (int [] arreglo) {

        int max = -999999, min = 999999, total = 0;
        for (int i: arreglo) {
            if (i > max) {
                max = i;
            }
            else if (i < min) {
                min = i;
            }
            total += i;
        }
        record = new Registro (max, min, (float) total/arreglo.length);
    }

    public static Registro getRegistro() {
        return record;
    }
}
