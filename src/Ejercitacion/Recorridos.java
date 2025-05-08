package Ejercitacion;

import Practica01.Ejercicio08.Queue;
import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Recorridos {

    public void imprimirPreorden(GeneralTree<Integer> nodo) {
        System.out.print(nodo.getData() + " | ");
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            imprimirPreorden(hijo);
        }
    }

    public void imprimirInorden(GeneralTree<Integer> nodo) {
        List<GeneralTree<Integer>> hijos = nodo.getChildren();
        int mitad = hijos.size() / 2;
        for (int i = 0; i < mitad; i++) {
            imprimirInorden(hijos.get(i));
        }
        System.out.print(nodo.getData() + " | ");
        for (int i = mitad; i < hijos.size(); i++) {
            imprimirInorden(hijos.get(i));
        }
    }

    public void imprimirPostorden(GeneralTree<Integer> nodo) {
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            imprimirPostorden(hijo);
        }
        System.out.print(nodo.getData() + " | ");
    }

    public void imprimirPorniveles(GeneralTree<Integer> nodo) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(nodo);
        while (!cola.isEmpty()) {
            GeneralTree<Integer> aux = cola.dequeue();
            System.out.print(aux.getData() + " | ");
            for (GeneralTree<Integer> hijo : aux.getChildren()) {
                cola.enqueue(hijo);
            }
        }
    }

    public static void main(String[] args) {
        List<GeneralTree<Integer>> hijo1 = new LinkedList<>();
        hijo1.add(new GeneralTree<>(11));
        GeneralTree<Integer> subArbol1 = new GeneralTree<>(7, hijo1);

        List<GeneralTree<Integer>> hijo2 = new LinkedList<>();
        hijo2.add(new GeneralTree<>(12));
        hijo2.add(new GeneralTree<>(13));
        hijo2.add(new GeneralTree<>(14));
        hijo2.add(new GeneralTree<>(15));
        GeneralTree<Integer> subArbol2 = new GeneralTree<>(10, hijo2);

        List<GeneralTree<Integer>> hijo3 = new LinkedList<>();
        hijo3.add(subArbol1);
        GeneralTree<Integer> subArbol3 = new GeneralTree<>(4, hijo3);

        List<GeneralTree<Integer>> hijo4 = new LinkedList<>();
        hijo4.add(new GeneralTree<>(8));
        hijo4.add(new GeneralTree<>(9));
        hijo4.add(subArbol2);
        GeneralTree<Integer> subArbol4 = new GeneralTree<>(5, hijo4);

        List<GeneralTree<Integer>> hijo5 = new LinkedList<>();
        hijo5.add(subArbol3);
        hijo5.add(subArbol4);
        GeneralTree<Integer> ArbolIzq = new GeneralTree<>(2, hijo5);

        List<GeneralTree<Integer>> hijo6 = new LinkedList<>();
        hijo6.add(new GeneralTree<>(6));
        GeneralTree<Integer> ArbolDer = new GeneralTree<>(3, hijo6);

        List<GeneralTree<Integer>> arboles = new LinkedList<>();
        arboles.add(ArbolIzq);
        arboles.add(ArbolDer);
        GeneralTree<Integer> arbol = new GeneralTree<>(1, arboles);

        Recorridos recorridos = new Recorridos();

        System.out.println("PreOrden ");
        recorridos.imprimirPreorden(arbol);
        System.out.println();
        System.out.println("InOrden ");
        recorridos.imprimirInorden(arbol);
        System.out.println();
        System.out.println("PostOrden ");
        recorridos.imprimirPostorden(arbol);
        System.out.println();
        System.out.println("Por niveles ");
        recorridos.imprimirPorniveles(arbol);

    }
}
