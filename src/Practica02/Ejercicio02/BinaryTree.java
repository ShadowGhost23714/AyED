package Practica02.Ejercicio02;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas () {
		if (this.isEmpty()) {
			return 0;
		} else if (!this.hasLeftChild() && !this.hasRightChild()) {
			return 1;
		} else {
			int hojas = 0;
			if (this.hasLeftChild()) {
				hojas += this.leftChild.contarHojas();
			}
			if (this.hasRightChild()) {
				hojas += this.rightChild.contarHojas();
			}
			return hojas;
		}
	}

    public BinaryTree<T> espejo () {
		BinaryTree<T> arbol = new BinaryTree<T>(this.getData());
		if (this.hasLeftChild()) {
			arbol.addRightChild(this.leftChild.espejo());
		}
		if (this.hasRightChild()) {
			arbol.addLeftChild(this.rightChild.espejo());
		}
		return arbol;
    }

	// 0<=n<=m
	public void entreNiveles (int n, int m) {
		if (this.isEmpty() || n < 0 || m < n) return;
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.add(this);
		int nivelActual = 0;
		while (!cola.isEmpty()){
			int nodoNivel = cola.size();
			if (nivelActual >=n && nivelActual <= m){
				for(int i=0; i < nodoNivel; i++) {
					BinaryTree<T> nodo = cola.remove();
					System.out.print(nodo.getData() + " | ");
					if(nodo.hasLeftChild()) {
						cola.add(nodo.getLeftChild());
					}
					if(nodo.hasRightChild()){
						cola.add(nodo.getRightChild());
					}
				}
			} else {
				for(int i=0; i < nodoNivel; i++) {
					cola.remove();
				}
			}
			nivelActual++;
			System.out.println();
		}
	}

	public void imprimirArbol() {
		if(this.hasLeftChild()){
			this.getLeftChild().imprimirArbol();
		}
		System.out.print(this.getData() + " ");
		if(this.hasRightChild()){
			this.getRightChild().imprimirArbol();
		}
	}
}

