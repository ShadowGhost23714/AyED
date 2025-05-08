package Practica02.Ejercicio03;

import Practica02.Ejercicio02.BinaryTree;

import java.util.*;

public class ContadorArbol {
    private BinaryTree<Integer> ab;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        ab = arbol;
    }

    public List<Integer> numerosParesInOrden() {
        List<Integer> lista = new ArrayList<>();
        if (!ab.isEmpty()){
            this.inOrden(ab, lista);
        }
        return lista;
    }

    private void inOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
        if (nodo != null && !nodo.isEmpty()){
            inOrden(nodo.getLeftChild(), lista);
            if (nodo.getData() % 2 == 0){
                lista.add(nodo.getData());
            }
            inOrden(nodo.getRightChild(), lista);
        }
    }

    public List<Integer> numerosParesPostOrden() {
        List<Integer> lista = new ArrayList<>();
        if (!ab.isEmpty()){
            this.postOrden(ab, lista);
        }
        return lista;
    }

    private void postOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
        if (nodo != null && !nodo.isEmpty()){
            postOrden(nodo.getLeftChild(), lista);
            postOrden(nodo.getRightChild(), lista);
            if (nodo.getData() % 2 == 0){
                lista.add(nodo.getData());
            }
        }
    }
}
