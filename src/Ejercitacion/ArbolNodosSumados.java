package Ejercitacion;

import Practica02.Ejercicio02.BinaryTree;

public class ArbolNodosSumados {
    private BinaryTree<Integer> arbol;

    public ArbolNodosSumados(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> nuevoTree () {
        BinaryTree<Integer> nuevo = new BinaryTree<>(arbol.getData());
        return construir (arbol, nuevo);
    }

    private BinaryTree<Integer> construir (BinaryTree<Integer> nodo, BinaryTree<Integer> nuevo) {
        if (nodo.hasLeftChild()) {
            int suma = nodo.getData() + nodo.getLeftChild().getData();
            nuevo.addLeftChild(new BinaryTree<>(suma));
            construir(nodo.getLeftChild(), nuevo.getLeftChild());
        }
        if (nodo.hasRightChild()) {
            nuevo.addRightChild(new BinaryTree<>(nodo.getRightChild().getData()));
            construir(nodo.getRightChild(), nuevo.getRightChild());
        }
        return nuevo;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(1);
        arbol.addLeftChild(new BinaryTree<>(2));
        arbol.addRightChild(new BinaryTree<>(3));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(4));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(5));
        arbol.getRightChild().addRightChild(new BinaryTree<>(6));
        arbol.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(7));

        arbol.imprimirArbol();
        System.out.println();
        ArbolNodosSumados pa = new ArbolNodosSumados(arbol);
        pa.nuevoTree().imprimirArbol();
    }
}
