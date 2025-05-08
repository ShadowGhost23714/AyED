package Practica03.Ejercicio08;

import Practica03.Ejercicio01.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Navidad {
    private GeneralTree<Integer> ab;

    public Navidad(GeneralTree<Integer> ab) {
        this.ab = ab;
    }

    public String esAbetoNavidenio() {
        boolean res = isAbeto(ab);
        return res ? "Yes" : "No";
    }

    private boolean isAbeto(GeneralTree<Integer> ab) {
        int nodosHoja = 0;
        for (GeneralTree<Integer> h: ab.getChildren()) {
            if (h.isLeaf()) {
                nodosHoja++;
            } else if (!isAbeto(h)) {
                return false;
            }
        }
        return nodosHoja >= 3;
    }

    public static void main(String[] args) {
        List<GeneralTree<Integer>> subArb1 = new LinkedList<>();
        subArb1.add(new GeneralTree<>(2));
        subArb1.add(new GeneralTree<>(3));
        subArb1.add(new GeneralTree<>(4));
        GeneralTree<Integer> a1 = new GeneralTree<>(1, subArb1);

        List<GeneralTree<Integer>> subArb2A = new LinkedList<>();
        subArb2A.add(new GeneralTree<>(5));
        subArb2A.add(new GeneralTree<>(6));
        subArb2A.add(new GeneralTree<>(7));
        GeneralTree<Integer> subA2 = new GeneralTree<>(2, subArb2A);
        List<GeneralTree<Integer>> subArb2B = new LinkedList<>();
        subArb2B.add(subA2);
        subArb2B.add(new GeneralTree<>(3));
        subArb2B.add(new GeneralTree<>(4));
        GeneralTree<Integer> a2 = new GeneralTree<>(1, subArb2B);

        List<GeneralTree<Integer>> subArb3A = new LinkedList<>();
        subArb3A.add(new GeneralTree<>(6));
        subArb3A.add(new GeneralTree<>(7));
        subArb3A.add(new GeneralTree<>(8));
        GeneralTree<Integer> subA3 = new GeneralTree<>(3, subArb3A);
        List<GeneralTree<Integer>> subArb3B = new LinkedList<>();
        subArb3B.add(new GeneralTree<>(2));
        subArb3B.add(subA3);
        subArb3B.add(new GeneralTree<>(4));
        subArb3B.add(new GeneralTree<>(5));
        GeneralTree<Integer> a3 = new GeneralTree<>(1, subArb3B);

        Navidad nav1 = new Navidad(a1);
        Navidad nav2 = new Navidad(a2);
        Navidad nav3 = new Navidad(a3);

        System.out.println("Es abeto navidenio A1? " + nav1.esAbetoNavidenio());
        System.out.println("Es abeto navidenio A2? " + nav2.esAbetoNavidenio());
        System.out.println("Es abeto navidenio A3? " + nav3.esAbetoNavidenio());
    }
}