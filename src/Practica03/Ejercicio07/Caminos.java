package Practica03.Ejercicio07;

import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> arbol;

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> caminoAHojaMasLejana () {
        List<Integer> act = new LinkedList<>();
        List<Integer> max = new LinkedList<>();
        if (!arbol.isEmpty()) {
            buscarCaminoAHojaMasLejana (arbol, act, max);
        }
        return max;
    }

    private void buscarCaminoAHojaMasLejana (GeneralTree<Integer> nodo, List<Integer> act, List<Integer> max) {
        act.add(nodo.getData());
        if (!nodo.isLeaf()) {
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                buscarCaminoAHojaMasLejana(hijo, act, max);
            }
        } else if (act.size() > max.size()) {
            max.removeAll(max);
            max.addAll(act);
        }
        act.remove(act.size()-1);
    }

    public static void main(String[] args) {
        List<GeneralTree<Integer>> subHijo1 = new LinkedList<>();
        subHijo1.add(new GeneralTree<>(1));
        GeneralTree<Integer> hijo1 = new GeneralTree<>(6, subHijo1);

        List<GeneralTree<Integer>> subHijo2 = new LinkedList<>();
        subHijo2.add(new GeneralTree<>(16));
        subHijo2.add(new GeneralTree<>(7));
        GeneralTree<Integer> hijo3 = new GeneralTree<>(14, subHijo2);

        List<GeneralTree<Integer>> subArbol1 = new LinkedList<>();
        subArbol1.add(new GeneralTree<>(10));
        subArbol1.add(hijo1);
        GeneralTree<Integer> arbol1 = new GeneralTree<>(17, subArbol1);

        List<GeneralTree<Integer>> hijo2 = new LinkedList<>();
        hijo2.add(new GeneralTree<>(8));
        GeneralTree<Integer> arbol2 = new GeneralTree<>(9, hijo2);

        List<GeneralTree<Integer>> subArbol2 = new LinkedList<>();
        subArbol2.add(hijo3);
        subArbol2.add(new GeneralTree<>(18));
        GeneralTree<Integer> arbol3 = new GeneralTree<>(15, subArbol2);

        List<GeneralTree<Integer>> arboles = new LinkedList<>();
        arboles.add(arbol1);
        arboles.add(arbol2);
        arboles.add(arbol3);
        GeneralTree<Integer> arbol = new GeneralTree<>(12, arboles);

        Caminos c = new Caminos(arbol);
        System.out.println(c.caminoAHojaMasLejana());
    }
}
