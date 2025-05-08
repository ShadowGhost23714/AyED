/*
Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un metodo denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el metodo realizando un recorrido InOrden.
b) Implemente el metodo realizando un recorrido PostOrden.
*/

package Practica02.Ejercicio03;

import Practica02.Ejercicio02.BinaryTree;

public class Ej03 {

    public static void main(String[] args) {

        System.out.println("Programa Números Pares");
        BinaryTree<Integer> arbol = new BinaryTree<>(4);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.addRightChild(new BinaryTree<>(6));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(3));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));
        arbol.getRightChild().addRightChild(new BinaryTree<>(8));

        ContadorArbol contador = new ContadorArbol(arbol);

        System.out.println("Nodos pares del árbol en InOrden son: "+ contador.numerosParesInOrden());
        System.out.println("Nodos pares del árbol en PostOrden son: "+ contador.numerosParesPostOrden());
    }
}
