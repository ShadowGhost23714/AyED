package Practica02.Ejercicio05;

import Practica02.Ejercicio02.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p) {
        return (!arbol.isEmpty()) ? sumaElementosProfundidad(p, arbol, 0) : 0;
    }

    private int sumaElementosProfundidad(int p, BinaryTree<Integer> nodo, int nivelActual){
        if (p == nivelActual){
            return nodo.getData();
        }
        int suma = 0;
        if (nodo.hasLeftChild()){
            suma += sumaElementosProfundidad(p, nodo.getLeftChild(), nivelActual+1);
        }
        if (nodo.hasRightChild()){
            suma += sumaElementosProfundidad(p, nodo.getRightChild(), nivelActual+1);
        }
        return suma;
    }
}
