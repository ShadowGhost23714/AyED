package Practica02.Ejercicio02;

public class Ej02 {

    public static void main(String[] args) {

        BinaryTree<Integer> arbol = new BinaryTree<Integer>(40);
        BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
        BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
        hijoDerecho.addLeftChild(new BinaryTree<Integer>(10));
        hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
        arbol.addLeftChild(hijoIzquierdo);
        arbol.addRightChild(hijoDerecho);

        System.out.println("Hojas del árbol = "+arbol.contarHojas());

        arbol.espejo();


    }
}