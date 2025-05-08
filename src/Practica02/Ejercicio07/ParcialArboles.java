package Practica02.Ejercicio07;

import Practica02.Ejercicio02.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    private BinaryTree<Integer> Buscar (BinaryTree<Integer> nodo, int num) {
        if (nodo == null || nodo.isEmpty()) {
            return null;
        }
        if (nodo.getData() == num) {
            return nodo;
        }
        BinaryTree<Integer> izq = null;
        if (nodo.hasLeftChild()) {
            izq = Buscar(nodo.getLeftChild(), num);
        }
        if (izq != null) {
            return izq;
        }
        if (nodo.hasRightChild()) {
            return Buscar(nodo.getRightChild(), num);
        }
        return null;
    }

    private int Contar (BinaryTree<Integer> nodo) {
        if (nodo == null || nodo.isEmpty()) {
            return 0;
        }
        int cant = 0;
        if (nodo.hasLeftChild() && !nodo.hasRightChild()) {
            cant = 1;
        } else if (!nodo.hasLeftChild() && nodo.hasRightChild()) {
            cant = 1;
        }
        int izq = nodo.hasLeftChild() ? Contar(nodo.getLeftChild()) : 0;
        int der = nodo.hasRightChild() ? Contar(nodo.getRightChild()): 0;
        return cant + izq + der;
    }

    public boolean isLeftTree (int num) {
        BinaryTree<Integer> ab = Buscar(arbol, num);
        if (ab == null) {
            return false;
        }
        int izq = ab.hasLeftChild() ? Contar(ab.getLeftChild()): -1;
        int der = ab.hasRightChild() ? Contar(ab.getRightChild()): -1;
        return izq > der;
    }
}
