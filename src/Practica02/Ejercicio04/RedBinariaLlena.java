package Practica02.Ejercicio04;

import Practica02.Ejercicio02.BinaryTree;

public class RedBinariaLlena {
    private BinaryTree <Integer>  red;

    public RedBinariaLlena(BinaryTree<Integer> red) {
        this.red = red;
    }

    public int retardoReenvio(){
        return calcularRetardo(this.red);
    }

    public int calcularRetardo(BinaryTree<Integer> red){
        int izq = 0;
        int der = 0;
        if (red.hasLeftChild()) {
            izq = calcularRetardo(red.getLeftChild());
        }
        if (red.hasRightChild()){
            der = calcularRetardo(red.getRightChild());
        }
        return Math.max(izq, der) + red.getData();
    }
}
