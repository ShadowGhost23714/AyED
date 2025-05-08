package Practica02.Ejercicio07;

import Practica02.Ejercicio02.BinaryTree;

public class Ej07 {

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<>(2);
        ab.addLeftChild(new BinaryTree<>(7));
        ab.addRightChild(new BinaryTree<>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(55));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(11));
        ab.getRightChild().addLeftChild(new BinaryTree<>(19));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
        ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(18));
        ab.entreNiveles(0, 4);

        ParcialArboles parcialArb = new ParcialArboles(ab);
        System.out.println("Resultado=" + parcialArb.isLeftTree(7));
        System.out.println("Resultado=" + parcialArb.isLeftTree(2));
        System.out.println("Resultado=" + parcialArb.isLeftTree(-5));
        System.out.println("Resultado=" + parcialArb.isLeftTree(19));
        System.out.println("Resultado=" + parcialArb.isLeftTree(-3));
    }
}
