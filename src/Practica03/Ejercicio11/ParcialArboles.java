package Practica03.Ejercicio11;

import Practica01.Ejercicio08.Queue;
import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (arbol.isEmpty()) {
            return false;
        }
        return (!arbol.isLeaf()) ? resolverAux(arbol): true;
    }

    public static boolean resolverAux (GeneralTree<Integer> nodo) {
        int cant = 1;
        int nodos = 0;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(nodo);
        while (!cola.isEmpty()) {
            if (cant != nodos + 1) {
                return false;
            }
            for (int i = 0; i < cant; i++) {
                GeneralTree<Integer> aux = cola.dequeue();
                for (GeneralTree<Integer> hijo : aux.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
            nodos = cant;
            cant = cola.size();
        }
        return true;
    }

    public static void main(String[] args) {
        List<GeneralTree<Integer>> hijo1 = new LinkedList<>();
        hijo1.add(new GeneralTree<>(83));
        GeneralTree<Integer> arbol_18 = new GeneralTree<>(18, hijo1);

        List<GeneralTree<Integer>> hijo2 = new LinkedList<>();
        hijo2.add(new GeneralTree<>(33));
        hijo2.add(new GeneralTree<>(12));
        hijo2.add(new GeneralTree<>(17));
        hijo2.add(new GeneralTree<>(9));
        GeneralTree<Integer> arbol_3 = new GeneralTree<>(3, hijo2);

        List<GeneralTree<Integer>> hijo3 = new LinkedList<>();
        hijo3.add(arbol_18);
        GeneralTree<Integer> arbol_5 = new GeneralTree<>(5, hijo3);

        List<GeneralTree<Integer>> hijo4 = new LinkedList<>();
        hijo4.add(new GeneralTree<>(7));
        hijo4.add(new GeneralTree<>(11));
        hijo4.add(arbol_3);
        GeneralTree<Integer> arbol_4 = new GeneralTree<>(4, hijo4);

        List<GeneralTree<Integer>> hijo5 = new LinkedList<>();
        hijo5.add(arbol_5);
        hijo5.add(arbol_4);
        GeneralTree<Integer> arbol_1 = new GeneralTree<>(1, hijo5);

        List<GeneralTree<Integer>> hijo6 = new LinkedList<>();
        hijo6.add(new GeneralTree<>(13));
        GeneralTree<Integer> arbol_25 = new GeneralTree<>(25, hijo6);

        List<GeneralTree<Integer>> hijo7 = new LinkedList<>();
        hijo7.add(arbol_1);
        hijo7.add(arbol_25);
        GeneralTree<Integer> arbol = new GeneralTree<>(2, hijo7);

        System.out.println("El árbol es creciente? " + resolver(arbol));
    }
}
