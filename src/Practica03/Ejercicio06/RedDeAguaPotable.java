package Practica03.Ejercicio06;

import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class RedDeAguaPotable {
    private GeneralTree<Character> arbol;

    public RedDeAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }

    public double minimoCaudal(double caudal) {
        if (arbol.isEmpty()) {
            return 0;
        }
        return (!arbol.isLeaf()) ? buscarMinimoCaudal(arbol, caudal): caudal;
    }

    private double buscarMinimoCaudal (GeneralTree<Character> nodo, double caudal) {
        if (nodo.isLeaf()) {
            return caudal;
        }
        double cantPorCaudal = caudal / nodo.getChildren().size();
        double caudalMin = Double.MAX_VALUE;
        for (GeneralTree<Character> hijo : nodo.getChildren()) {
            double caudalHijo = buscarMinimoCaudal(hijo, cantPorCaudal);
            caudalMin = Math.min(caudalMin, caudalHijo);
        }
        return caudalMin;
    }

    public static void main(String[] args) {
        GeneralTree<Character> arbol1 = new GeneralTree<>('B');

        List<GeneralTree<Character>> subHijo1 = new LinkedList<>();
        subHijo1.add(new GeneralTree<>('L'));
        GeneralTree<Character> subArbol1 = new GeneralTree<>('G', subHijo1);

        List<GeneralTree<Character>> subHijo2 = new LinkedList<>();
        subHijo2.add(new GeneralTree<>('F'));
        subHijo2.add(subArbol1);
        GeneralTree<Character> arbol2 = new GeneralTree<>('C', subHijo2);

        List<GeneralTree<Character>> subHijo3 = new LinkedList<>();
        subHijo3.add(new GeneralTree<>('M'));
        subHijo3.add(new GeneralTree<>('N'));
        GeneralTree<Character> subArbol2 = new GeneralTree<>('J', subHijo3);

        List<GeneralTree<Character>> subHijo4 = new LinkedList<>();
        subHijo4.add(new GeneralTree<>('H'));
        subHijo4.add(new GeneralTree<>('I'));
        subHijo4.add(subArbol2);
        subHijo4.add(new GeneralTree<>('K'));
        subHijo4.add(new GeneralTree<>('P'));
        GeneralTree<Character> arbol3 = new GeneralTree<>('D', subHijo4);

        GeneralTree<Character> arbol4 = new GeneralTree<>('E');

        List<GeneralTree<Character>> arboles = new LinkedList<>();
        arboles.add(arbol1);
        arboles.add(arbol2);
        arboles.add(arbol3);
        arboles.add(arbol4);
        GeneralTree<Character> arbol = new GeneralTree<>('A', arboles);

        RedDeAguaPotable red = new RedDeAguaPotable(arbol);
        System.out.println("El caudal minimo que recibe una casa es de " + red.minimoCaudal(1000) + " litros");
    }
}