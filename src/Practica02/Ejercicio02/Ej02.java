package Practica02.Ejercicio02;

public class Ej02 {

    public static void main(String[] args) {

        BinaryTree<Integer> arbol = new BinaryTree<>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<>(25);
        BinaryTree<Integer> hijoDerecho = new BinaryTree<>(78);
        hijoDerecho.addLeftChild(new BinaryTree<>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<>(32));
        arbol.addLeftChild(hijoIzquierdo);
        arbol.addRightChild(hijoDerecho);

        System.out.println("Hojas del árbol = "+arbol.contarHojas());
        System.out.println("Árbol original: ");
        arbol.imprimirArbol();
        System.out.println();
        System.out.println("Árbol espejo: ");
        BinaryTree<Integer> arbolEspejo = arbol.espejo();
        arbolEspejo.imprimirArbol();
        System.out.println();
        System.out.println("Árbol por niveles: ");
        arbol.entreNiveles(0, 2);
    }
}