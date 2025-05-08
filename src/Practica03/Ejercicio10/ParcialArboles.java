package Practica03.Ejercicio10;

import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> caminoActual = new LinkedList<>();
        List<Integer> resultado = new LinkedList<>();
        Maximo max = new Maximo(Integer.MIN_VALUE);
        resolverAux(arbol, caminoActual, resultado, max, 0, 0);
        return resultado;
    }

    private static void resolverAux (GeneralTree<Integer> nodo,
                                     List<Integer> caminoActual, List<Integer> resultado,
                                     Maximo max, int nivel, int suma) {

        int datoActaul = nodo.getData();
        boolean ok = (datoActaul == 1);
        if (ok) {
            suma += datoActaul * nivel;
            caminoActual.add(datoActaul);
        }
        if (!nodo.isLeaf()) {
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                resolverAux(hijo, caminoActual, resultado, max, nivel+1, suma);
            }
        } else if (suma > max.getMax()) {
            max.setMax(suma);
            resultado.clear();
            resultado.addAll(caminoActual);
        }
        if (ok) {
            caminoActual.remove(caminoActual.size()-1);
        }
    }

    public static void main(String[] args) {
        List<GeneralTree<Integer>> hijo1 = new LinkedList<>();
        hijo1.add(new GeneralTree<>(1));
        hijo1.add(new GeneralTree<>(1));
        hijo1.add(new GeneralTree<>(1));
        GeneralTree<Integer> arbol1 = new GeneralTree<>(1, hijo1);

        List<GeneralTree<Integer>> hijo2 = new LinkedList<>();
        hijo2.add(arbol1);
        hijo2.add(new GeneralTree<>(1));
        GeneralTree<Integer> arbolIzq = new GeneralTree<>(0, hijo2);

        List<GeneralTree<Integer>> hijo3 = new LinkedList<>();
        hijo3.add(new GeneralTree<>(1));
        GeneralTree<Integer> arbol2 = new GeneralTree<>(0, hijo3);

        List<GeneralTree<Integer>> hijo4 = new LinkedList<>();
        hijo4.add(arbol2);
        GeneralTree<Integer> arbol3 = new GeneralTree<>(0, hijo4);

        List<GeneralTree<Integer>> hijo5 = new LinkedList<>();
        hijo5.add(new GeneralTree<>(1));
        hijo5.add(arbol3);
        GeneralTree<Integer> arbolMid = new GeneralTree<>(1);

        List<GeneralTree<Integer>> hijo6 = new LinkedList<>();
        hijo6.add(new GeneralTree<>(0));
        hijo6.add(new GeneralTree<>(0));
        GeneralTree<Integer> arbol4 = new GeneralTree<>(0, hijo6);

        List<GeneralTree<Integer>> hijo7 = new LinkedList<>();
        hijo7.add(arbol4);
        GeneralTree<Integer> arbol5 = new GeneralTree<>(0, hijo7);

        List<GeneralTree<Integer>> hijo8 = new LinkedList<>();
        hijo8.add((arbol5));
        GeneralTree<Integer> arbolDer = new GeneralTree<>(1, hijo8);

        List<GeneralTree<Integer>> arboles = new LinkedList<>();
        arboles.add(arbolIzq);
        arboles.add(arbolMid);
        arboles.add(arbolDer);
        GeneralTree<Integer> arbol = new GeneralTree<>(1, arboles);

        System.out.println("Camino filtrado de valor máximo = " + resolver(arbol));
    }
}
