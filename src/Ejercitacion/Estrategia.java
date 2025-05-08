package Ejercitacion;

import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Estrategia {

    public List<Neumatico> mejorEstrategia (GeneralTree<Neumatico> arbol) {
        List<Neumatico> actual = new LinkedList<>();
        List<Neumatico> max = new LinkedList<>();
        if (!arbol.isEmpty()) {
            buscarMejorEstrategia (arbol, actual, max);
        }
        return max;
    }

    private void buscarMejorEstrategia (GeneralTree<Neumatico> nodo, List<Neumatico> actual, List<Neumatico> max) {

    }

    public static void main(String[] args) {
        List<GeneralTree<Neumatico>> hijo1 = new LinkedList<>();
        hijo1.add(new GeneralTree<>(new Neumatico(30, "Hard")));
        GeneralTree<Neumatico> arbol1 = new GeneralTree<>(new Neumatico(10, "Soft"), hijo1);

        List<GeneralTree<Neumatico>> hijo2 = new LinkedList<>();
        hijo2.add(new GeneralTree<>(new Neumatico(15, "Med")));
        GeneralTree<Neumatico> arbol2 = new GeneralTree<>(new Neumatico(15, "Med"), hijo2);

        List<GeneralTree<Neumatico>> hijo3 = new LinkedList<>();
        hijo3.add(arbol1);
        GeneralTree<Neumatico> arbolIzq = new GeneralTree<>(new Neumatico(10, "Soft"), hijo3);

        List<GeneralTree<Neumatico>> hijo4 = new LinkedList<>();
        hijo4.add(new GeneralTree<>(new Neumatico(30, "Hard")));
        hijo4.add(arbol2);
        GeneralTree<Neumatico> arbolMed = new GeneralTree<>(new Neumatico(20, "Hard"), hijo4);

        List<GeneralTree<Neumatico>> hijo5 = new LinkedList<>();
        hijo5.add(new GeneralTree<>(new Neumatico(15, "Soft")));
        GeneralTree<Neumatico> arbolDer = new GeneralTree<>(new Neumatico(35, "Hard"), hijo5);

        List<GeneralTree<Neumatico>> arboles = new LinkedList<>();
        arboles.add(arbolIzq);
        arboles.add(arbolMed);
        arboles.add(arbolDer);
        GeneralTree<Neumatico> arbolEstrategia = new GeneralTree<>(new Neumatico(0, ""), arboles);

        Estrategia estrategia = new Estrategia();
        System.out.println("La mejor estrategia es " + estrategia.mejorEstrategia(arbolEstrategia));
    }
}
