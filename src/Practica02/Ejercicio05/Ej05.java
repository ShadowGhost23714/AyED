/*
Implemente una clase Java llamada ProfundidadDeArbolBinario que tiene como variable de
instancia un árbol binario de números enteros y un metodo de instancia
sumaElementosProfundidad (int p):int el cuál devuelve la suma de todos los nodos del árbol
que se encuentren a la profundidad pasada como argumento.
 */

package Practica02.Ejercicio05;

import Practica02.Ejercicio02.BinaryTree;

public class Ej05 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<Integer>(2));
        arbol.addRightChild(new BinaryTree<Integer>(6));
        arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        arbol.getRightChild().addRightChild(new BinaryTree<Integer>(8));

        int p = 2;
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(arbol);
        System.out.println("La suma de todos los nodos de la profundidad "+p+" es de = "+ prof.sumaElementosProfundidad(p));
    }
}
