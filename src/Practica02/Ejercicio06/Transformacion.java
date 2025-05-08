package Practica02.Ejercicio06;

import Practica02.Ejercicio02.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> suma (){
        suma(arbol);
        return arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    private int suma (BinaryTree<Integer> arbol){
         int sum = 0;
         if (arbol.isLeaf()){
             sum = arbol.getData();
             arbol.setData(0);
             return sum;
         }
         if (arbol.hasLeftChild()) {
             sum += suma(arbol.getLeftChild());
         }
         if (arbol.hasRightChild()){
             sum += suma(arbol.getRightChild());
         }
         int actual = arbol.getData();
         arbol.setData(sum);
         return sum + actual;
    }
}
