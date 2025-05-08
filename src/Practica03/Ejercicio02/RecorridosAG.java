package Practica03.Ejercicio02;

import Practica03.Ejercicio01.GeneralTree;

import java.util.*;

public class RecorridosAG {

    /*
    Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    pasados como parámetros, recorrido en preorden.
     */

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new LinkedList<>();
        if (a != null && !a.isEmpty()) {
            numerosImparesMayoresQuePreOrdenRec(a, resultado, n);
        }
        return resultado;
    }

    private void numerosImparesMayoresQuePreOrdenRec (GeneralTree<Integer> a, List<Integer> resultado, Integer n) {
        int dato = a.getData();
        if (dato % 2 != 0 && dato > n) {
            resultado.add(dato);
        }
        for (GeneralTree<Integer> hijo: a.getChildren()) {
            numerosImparesMayoresQuePreOrdenRec(hijo, resultado, n);
        }
    }

    /*
    Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    pasados como parámetros, recorrido en inorden.
     */

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
        List<Integer> resultado = new LinkedList<>();
        if (a != null && !a.isEmpty()) {
            numerosImparesMayoresQueInOrdenRec(a, resultado, n);
        }
        return resultado;
    }

    private void numerosImparesMayoresQueInOrdenRec (GeneralTree <Integer> a, List<Integer> resultado, Integer n) {
        List<GeneralTree<Integer>> hijos = a.getChildren();
        if (!hijos.isEmpty()) {
            // Recorrer los hijos de izquierda a derecha
            for (int i = 0; i < hijos.size(); i++) {
                // Recursión para cada hijo
                numerosImparesMayoresQueInOrdenRec(hijos.get(i), resultado, n);
            }
        }
        int dato = a.getData();
        if (dato % 2 != 0 && dato > n) {
            resultado.add(dato);
        }
    }

    /*
    Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    pasados como parámetros, recorrido en postorden.
     */

    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
        List<Integer> resultado = new LinkedList<>();
        if (a != null && !a.isEmpty()) {
            numerosImparesMayoresQuePostOrdenRec(a, resultado, n);
        }
        return resultado;
    }

    private void numerosImparesMayoresQuePostOrdenRec (GeneralTree <Integer> a, List<Integer> resultado, Integer n) {
        for (GeneralTree<Integer> hijo : a.getChildren()) {
            numerosImparesMayoresQuePostOrdenRec(hijo, resultado, n);
        }
        int dato = a.getData();
        if (dato % 2 != 0 && dato > n) {
            resultado.add(dato);
        }
    }

    /*
    Metodo que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
    pasados como parámetros, recorrido por niveles.
     */

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
        List<Integer> resultado = new LinkedList<>();
        if (a != null && !a.isEmpty()) {
            Queue<GeneralTree<Integer>> cola = new LinkedList<>();
            cola.add(a);
            while (!cola.isEmpty()) {
                GeneralTree<Integer> actual = cola.poll();
                int dato = actual.getData();
                if (dato % 2 != 0 && dato > n) {
                    resultado.add(dato);
                }
                cola.addAll(actual.getChildren());
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<>(10);
        GeneralTree<Integer> nodo1 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(8);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(15);
        a1.addChild(nodo1);
        a1.addChild(nodo2);
        a1.addChild(nodo3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(7);
        nodo1.addChild(nodo4);
        nodo1.addChild(nodo5);

        RecorridosAG rec = new RecorridosAG();

        System.out.println("PreOrden: " + rec.numerosImparesMayoresQuePreOrden(a1, 0));
        System.out.println("InOrden: " + rec.numerosImparesMayoresQueInOrden(a1, 0));
        System.out.println("PostOrden: " + rec.numerosImparesMayoresQuePostOrden(a1, 0));
        System.out.println("Entre niveles: " + rec.numerosImparesMayoresQuePorNiveles(a1, 0));
    }
}
