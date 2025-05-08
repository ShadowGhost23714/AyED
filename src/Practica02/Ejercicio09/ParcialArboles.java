package Practica02.Ejercicio09;

import Practica02.Ejercicio02.BinaryTree;

public class ParcialArboles {

    public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol){
        BinaryTree<SumDif> arbolSad = new BinaryTree<>();
        if (!arbol.isEmpty()) {
            this.sumAndDif(arbol, arbolSad, 0, 0);
        }
        return arbolSad;
    }

    private void sumAndDif (BinaryTree<Integer> arbol, BinaryTree<SumDif> arbolSad, int padre, int sum) {
        int datoActual = arbol.getData();
        SumDif sad = new SumDif(datoActual + sum, datoActual - padre);
        arbolSad.setData(sad);
        if (arbol.hasLeftChild()) {
            arbolSad.addLeftChild(new BinaryTree<>());
            sumAndDif(arbol.getLeftChild(), arbolSad.getLeftChild(), datoActual, datoActual + sum);
        }
        if (arbol.hasRightChild()) {
            arbolSad.addRightChild(new BinaryTree<>());
            sumAndDif(arbol.getRightChild(), arbolSad.getRightChild(), datoActual, datoActual + sum);
        }
    }

    public static void main(String[] args) {
        ParcialArboles parcialArb = new ParcialArboles();

        BinaryTree<Integer> ab = new BinaryTree<>(20);
        ab.addLeftChild(new BinaryTree<>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<>(-5));
        ab.getLeftChild().addRightChild(new BinaryTree<>(10));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(1));
        ab.addRightChild(new BinaryTree<>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<>(50));
        ab.getRightChild().addRightChild(new BinaryTree<>(-9));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
        ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<>(6));

        ab.entreNiveles(0, 4);
        System.out.println();
        System.out.println("Nuevo arbol:");
        parcialArb.sumAndDif(ab).entreNiveles(0, 4);
    }
}
