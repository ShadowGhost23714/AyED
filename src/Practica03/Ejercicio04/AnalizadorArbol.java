package Practica03.Ejercicio04;

import Practica01.Ejercicio08.Queue;
import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class AnalizadorArbol {

    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
        if (arbol.isEmpty()) {
            return 0;
        }
        return (!arbol.isLeaf()) ? devolverMaximoPromedioAux(arbol): arbol.getData().getTardanza();
    }

    private double devolverMaximoPromedioAux(GeneralTree<AreaEmpresa> arbol) {
        double max = -1;
        int suma = 0;
        int nodos = 0;
        GeneralTree<AreaEmpresa> a;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            a = cola.dequeue();
            if (a != null) {
                nodos++;
                suma += a.getData().getTardanza();
                List<GeneralTree<AreaEmpresa>> hijos = a.getChildren();
                for (GeneralTree<AreaEmpresa> hijo : hijos) {
                    cola.enqueue(hijo);
                }
            } else if (!cola.isEmpty()) {
                suma = suma / nodos;
                max = Math.max(suma, max);
                cola.enqueue(null);
                suma = 0;
                nodos = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<GeneralTree<AreaEmpresa>> hijo1 = new LinkedList<>();
        hijo1.add(new GeneralTree<>(new AreaEmpresa("A", 4)));
        hijo1.add(new GeneralTree<>(new AreaEmpresa("B", 7)));
        hijo1.add(new GeneralTree<>(new AreaEmpresa("C", 5)));
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<>(new AreaEmpresa("J", 13), hijo1);

        List<GeneralTree<AreaEmpresa>> hijo2 = new LinkedList<>();
        hijo2.add(new GeneralTree<>(new AreaEmpresa("D", 6)));
        hijo2.add(new GeneralTree<>(new AreaEmpresa("E", 10)));
        hijo2.add(new GeneralTree<>(new AreaEmpresa("F", 18)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<>(new AreaEmpresa("k", 25), hijo2);

        List<GeneralTree<AreaEmpresa>> hijo3 = new LinkedList<>();
        hijo3.add(new GeneralTree<>(new AreaEmpresa("G", 9)));
        hijo3.add(new GeneralTree<>(new AreaEmpresa("H", 12)));
        hijo3.add(new GeneralTree<>(new AreaEmpresa("I", 19)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<>(new AreaEmpresa("L", 10), hijo3);

        List<GeneralTree<AreaEmpresa>> hijo4 = new LinkedList<>();
        hijo4.add(a1);
        hijo4.add(a2);
        hijo4.add(a3);
        GeneralTree<AreaEmpresa> arbol = new GeneralTree<>(new AreaEmpresa("M", 14), hijo4);

        AnalizadorArbol analizador = new AnalizadorArbol();

        System.out.println("El máximo promedio de tardanza del árbol es de " + analizador.devolverMaximoPromedio(arbol));
    }
}
