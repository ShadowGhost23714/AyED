package Practica01.Ejercicio07;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void Metodo () {

        // Inciso D.1
        List<Estudiante> lista1 = new ArrayList<>();
        lista1.add(new Estudiante("Juan", 1));
        lista1.add(new Estudiante("Carlos", 2));
        lista1.add(new Estudiante("Matías", 3));

        // Inciso D.2
        List<Estudiante> lista2 = new ArrayList<>(lista1);

        // Inciso D.3
        for (Estudiante e : lista1) {
            System.out.println(e.toString());
        }
        for (Estudiante e : lista2) {
            System.out.println(e.toString());
        }

        // Inciso D.4
        Estudiante estudiante = new Estudiante("Lalo",4);
        lista1.set(2, estudiante);

        // Inciso D.5
        for (Estudiante e : lista1) {
            System.out.println(e.toString());
        }
        for (Estudiante e : lista2) {
            System.out.println(e.toString());
        }

        // Inciso E
        estudiante = new Estudiante("Martín", 5);
        boolean encontre = false;
        for (Estudiante e : lista1) {
            if (e.equals(estudiante)) {
                encontre = true;
                break;
            }
        }
        if (!encontre) {
            lista1.add(estudiante);
        }

        System.out.println(lista1.toString());
        System.out.println(lista2.toString());
    }

    public static void main(String[] args) {

        // Inciso A
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        for (Integer numero : numeros) {
            System.out.println (numero);
        }

        // Inciso D
        Metodo();

        // Inciso F
            // Sin terminar
    }
}