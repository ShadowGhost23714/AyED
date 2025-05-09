package Practica02.Ejercicio08;

import Practica02.Ejercicio02.BinaryTree;

public class ParcialArboles {

    private boolean esPrefijoAux (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if (arbol1.getData() != arbol2.getData()) {
            return false;
        }
        boolean res = true;
        if (arbol1.hasLeftChild()) {
            if (arbol2.hasLeftChild()) {
                res = res && esPrefijoAux(arbol1.getLeftChild(), arbol2.getLeftChild());
            } else {
                return false;
            }
        }
        if (arbol1.hasRightChild()) {
            if (arbol2.hasRightChild()) {
                res = res && esPrefijoAux(arbol1.getRightChild(), arbol2.getRightChild());
            } else {
                return false;
            }
        }
        return res;
    }

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if (arbol1.isEmpty() || arbol2.isEmpty()) {
            return arbol1.isEmpty() && arbol2.isEmpty();
        }
        return esPrefijoAux(arbol1, arbol2);
    }

    public static void main(String[] args) {
        ParcialArboles parcialArboles = new ParcialArboles();

        BinaryTree<Integer> ab1 = new BinaryTree<>(4);
        ab1.addLeftChild(new BinaryTree<>(2));
        ab1.addRightChild(new BinaryTree<>(6));
        ab1.getLeftChild().addLeftChild(new BinaryTree<>(1));
        ab1.getLeftChild().addRightChild(new BinaryTree<>(3));

        BinaryTree<Integer> ab2 = new BinaryTree<>(4);
        ab2.addLeftChild(new BinaryTree<>(2));
        ab2.addRightChild(new BinaryTree<>(6));
        ab2.getLeftChild().addLeftChild(new BinaryTree<>(1));
        ab2.getLeftChild().addRightChild(new BinaryTree<>(3));
        ab2.getRightChild().addLeftChild(new BinaryTree<>(5));
        ab2.getRightChild().addRightChild(new BinaryTree<>(8));

        BinaryTree<Integer> ab3 = new BinaryTree<>(4);
        ab3.addLeftChild(new BinaryTree<>(2));
        ab3.addRightChild(new BinaryTree<>(6));
        ab3.getLeftChild().addLeftChild(new BinaryTree<>(1));
        ab3.getLeftChild().addRightChild(new BinaryTree<>(3));

        BinaryTree<Integer> ab4 = new BinaryTree<>(4);
        ab4.addLeftChild(new BinaryTree<>(2));
        ab4.addRightChild(new BinaryTree<>(6));
        ab4.getLeftChild().addRightChild(new BinaryTree<>(3));
        ab4.getRightChild().addLeftChild(new BinaryTree<>(5));

        BinaryTree<Integer> ab5 = new BinaryTree<>();
        BinaryTree<Integer> ab6 = new BinaryTree<>();

        BinaryTree<Integer> ab7 = new BinaryTree<>(3);
        BinaryTree<Integer> ab8 = new BinaryTree<>();

        BinaryTree<Integer> ab9 = new BinaryTree<>();
        BinaryTree<Integer> ab10 = new BinaryTree<>(3);

        System.out.println("Ab1 es prefijo de ab2? " + parcialArboles.esPrefijo(ab1, ab2));
        System.out.println("Ab3 es prefijo de ab4? " + parcialArboles.esPrefijo(ab3, ab4));
        System.out.println("Ab5 es prefijo de ab6? " + parcialArboles.esPrefijo(ab5, ab6));
        System.out.println("Ab7 es prefijo de ab8? " + parcialArboles.esPrefijo(ab7, ab8));
        System.out.println("Ab9 es prefijo de ab10? " + parcialArboles.esPrefijo(ab9, ab10));
    }
}
