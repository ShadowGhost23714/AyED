package Practica03.Ejercicio01;

import java.util.*;
import Practica01.Ejercicio08.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		return (!this.isEmpty()) ? alturaAux(): -1;
	}

	private int alturaAux() {
		if (this.isLeaf()) {
			return 0;
		}
		int altura = -1;
		List<GeneralTree<T>> hijos = this.getChildren();
		for (GeneralTree<T> hijo : hijos) {
			altura = Math.max(altura, hijo.alturaAux());
		}
		return altura + 1;
	}

	public int nivel(T dato){
		return (!this.isEmpty()) ? nivelAux(dato): -1;
	}

	private int nivelAux(T dato) {
		int cont = 0;
		int act;
		GeneralTree<T> a;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		while (!cola.isEmpty()) {
			act = cola.size();
			for (int i = 0; i < act; i++) {
				a = cola.dequeue();
				if (a.getData().equals(dato)) {
					return cont;
				} else {
					for (GeneralTree<T> hijo : a.getChildren()) {
						cola.enqueue(hijo);
					}
				}
			}
			cont++;
		}
		return -1;
	}

	public int ancho(){
		if (this.isEmpty()) {
			return 0;
		}
		return (!this.isLeaf()) ? anchoAux(): 1;
	}

	private int anchoAux() {
		int cantMax = 0;
		int cantActual = 0;
		GeneralTree<T> a;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			a = cola.dequeue();
			if (a != null) {
				List<GeneralTree<T>> hijos = a.getChildren();
				for (GeneralTree<T> hijo: hijos) {
					cola.enqueue(hijo);
					cantActual++;
				}
			} else if (!cola.isEmpty()) {
				cantMax = Math.max(cantMax, cantActual);
				cantActual = 0;
				cola.enqueue(null);
			}
		}
		return cantMax;
	}

	/*
	public boolean esAncestro(T a, T b) {
		if (this.isEmpty()) {
			return false;
		}
		GeneralTree<T> nodo = buscarNodo(this, a);
		if (nodo == null) {
			return false;
		}
		return esAncestroAux(nodo, b);
	}

	private GeneralTree<T> buscarNodo (GeneralTree<T> nodo, T a) {
		if (nodo.getData().equals(a)) {
			return nodo;
		}
		for (GeneralTree<T> hijo : nodo.getChildren()) {
			GeneralTree<T> resultado = buscarNodo(hijo, a);
			if (resultado != null) {
				return resultado;
			}
		}
		return null;
	}

	private boolean esAncestroAux(GeneralTree<T> nodo, T b){
		if (nodo.getData().equals(b)) {
			return true;
		}
		for (GeneralTree<T> hijo : nodo.getChildren()) {
			if (esAncestroAux(hijo, b)) {
				return true;
			}
		}
		return false;
	}
	*/

	public boolean esAncestro(T a, T b) {
        if (this.isEmpty()) return false;
        else return esAncestroBusqueda(a, b);
    }

    private boolean esAncestroBusqueda(T a, T b) {
        boolean res = false;
        GeneralTree<T> nodoRaiz = null;
        GeneralTree<T> ab;
        Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
        cola.enqueue(this);
        while(!cola.isEmpty() && (!res)) {
			ab = cola.dequeue();
			if (ab.getData().equals(b) && (!res)) {
				return false; //Encontre B antes que A
			}
			if(ab.getData().equals(a)) {
                res = true;
                nodoRaiz = ab;
            }
            if(!res) {
                List<GeneralTree<T>> children = ab.getChildren();
                for(GeneralTree<T> child: children) {
                        cola.enqueue(child);
                    }
                }
        }
        return res ? esAncestroHelper(nodoRaiz, b): false;
    }

    private boolean esAncestroHelper(GeneralTree<T> ab, T b) {
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
        queue.enqueue(ab);
        while(!queue.isEmpty()) {
            aux = queue.dequeue();
            if(aux.getData().equals(b)) {
                return true;
            } else {
                List<GeneralTree<T>> children = aux.getChildren();
                for (GeneralTree<T> child: children) {
                    queue.enqueue(child);
                }
            }
        }
        return false;
    }
}