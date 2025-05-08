package Practica03.Ejercicio09;

import Practica01.Ejercicio08.Queue;
import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        boolean ok = true;
        if (!arbol.isEmpty()) {
            cola.enqueue(arbol);
            while (!cola.isEmpty() && ok) {
                GeneralTree<Integer> aux = cola.dequeue();
                int min = Integer.MAX_VALUE;
                for (GeneralTree<Integer> hijo : aux.getChildren()) {
                    cola.enqueue(hijo);
                    min = Math.min(min, hijo.getData());
                }
                if (!aux.isLeaf() && aux.getData() != min) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public static void main(String[] args) {

        List<GeneralTree<Integer>> hijo1 = new LinkedList<>();
        hijo1.add(new GeneralTree<>(35));
        GeneralTree<Integer> subArbol1 = new GeneralTree<>(35, hijo1);

        List<GeneralTree<Integer>> hijo2 = new LinkedList<>();
        hijo2.add(new GeneralTree<>(35));
        hijo2.add(new GeneralTree<>(83));
        hijo2.add(new GeneralTree<>(90));
        hijo2.add(new GeneralTree<>(33));
        GeneralTree<Integer> subArbol2 = new GeneralTree<>(33, hijo2);

        List<GeneralTree<Integer>> hijo3 = new LinkedList<>();
        hijo3.add(subArbol1);
        GeneralTree<Integer> subArbol3 = new GeneralTree<>(35, hijo3);

        List<GeneralTree<Integer>> hijo4 = new LinkedList<>();
        hijo4.add(new GeneralTree<>(14));
        hijo4.add(new GeneralTree<>(12));
        hijo4.add(subArbol2);
        GeneralTree<Integer> subArbol4 = new GeneralTree<>(12, hijo4);

        List<GeneralTree<Integer>> hijo5 = new LinkedList<>();
        hijo5.add(subArbol3);
        hijo5.add(subArbol4);
        GeneralTree<Integer> ArbolIzq = new GeneralTree<>(12, hijo5);

        List<GeneralTree<Integer>> hijo6 = new LinkedList<>();
        hijo6.add(new GeneralTree<>(25));
        GeneralTree<Integer> ArbolDer = new GeneralTree<>(25, hijo6);

        List<GeneralTree<Integer>> arboles = new LinkedList<>();
        arboles.add(ArbolIzq);
        arboles.add(ArbolDer);
        GeneralTree<Integer> arbol = new GeneralTree<>(12, arboles);

        System.out.println("El árbol es de seleccion? " + esDeSeleccion(arbol));
    }
}
