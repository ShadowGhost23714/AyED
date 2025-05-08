package Practica03.Ejercicio05;

import Practica03.Ejercicio01.GeneralTree;

public class Ej05 {

    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<>(10);
        GeneralTree<Integer> nodo1 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(8);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(15);
        a1.addChild(nodo1);
        a1.addChild(nodo2);
        a1.addChild(nodo3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(7);
        nodo1.addChild(nodo4);
        nodo1.addChild(nodo5);

        System.out.println("10 es ancestro 3 = " + a1.esAncestro(10, 3));
        System.out.println("5 es ancestro 7 = " + a1.esAncestro(5, 7));
        System.out.println("15 no es ancestro 5 = " + a1.esAncestro(15, 5));
    }
}
