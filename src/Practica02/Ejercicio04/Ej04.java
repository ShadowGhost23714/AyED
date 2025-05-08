/*
Una red binaria es una red que posee una topología de árbol binario lleno.
Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre
que un nodo recibe un mensaje y lo reenvía a sus dos hijos.

Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz
hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería retornar 10+3+9+12=34
(Si hay más de un máximo retorne el último valor hallado).
Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
segundos.

a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
problema.

b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
metodo retardoReenvio():int
*/

package Practica02.Ejercicio04;

import Practica02.Ejercicio02.BinaryTree;

public class Ej04 {

    public static void main(String[] args) {

        BinaryTree<Integer> arbol = new BinaryTree<>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));
        arbol.getRightChild().addRightChild(new BinaryTree<>(8));

        RedBinariaLlena red = new RedBinariaLlena(arbol);
        System.out.println("Mayor retardo de reenvío: " + red.retardoReenvio());
    }
}
