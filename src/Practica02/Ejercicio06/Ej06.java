/*
Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
binario de números enteros y un metodo de instancia suma (): BinaryTree<Integer> el cuál
devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
vacíos son ceros.
¿Su solución recorre una única vez cada subárbol? En el caso que no, ¿Puede mejorarla para que
sí lo haga?
 */

package Practica02.Ejercicio06;

import Practica02.Ejercicio02.BinaryTree;

public class Ej06 {

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<Integer>(4);
        arbol.addLeftChild(new BinaryTree<Integer>(2));
        arbol.addRightChild(new BinaryTree<Integer>(6));
        arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        arbol.getRightChild().addRightChild(new BinaryTree<Integer>(8));

        System.out.println("Árbol original: ");
        arbol.imprimirArbol();
        Transformacion arbol2 = new Transformacion(arbol);
        arbol2.suma();
        System.out.println();
        System.out.println("Árbol transformado: ");
        arbol2.getArbol().imprimirArbol();
    }
}
