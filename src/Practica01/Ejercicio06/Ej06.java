package Practica01.Ejercicio06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ej06 {

    public static void main(String[] args) {

/*
Análisis de las estructuras de listas provistas por la API de Java.

a. ¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList?

ArrayList es más eficiente cuando:
✅ Se accede frecuentemente a los elementos por índice (get(i)), ya que permite acceso directo en O(1) (tiempo constante).
✅ Se recorren los elementos con un for tradicional o un for-each, porque almacena los datos de forma contigua en memoria, mejorando la localidad de caché.
✅ Las inserciones y eliminaciones ocurren al final de la lista, ya que simplemente se agrega un nuevo elemento sin necesidad de reubicar los existentes.
✅ Se necesita menos uso de memoria, ya que solo almacena los elementos en un array sin referencias extra.

Ejemplo donde ArrayList es mejor:
*/
        List<Integer> lista1 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            lista1.add(i);  // Rápido porque siempre se agrega al final
        }
        int valor = lista1.get(500000);  // Acceso en O(1)

/*
b. ¿Cuándo LinkedList puede ser más eficiente que ArrayList?

LinkedList es más eficiente cuando:
✅ Se realizan muchas inserciones o eliminaciones en el medio de la lista, ya que no requiere desplazar elementos, solo ajustar referencias (O(1) en el mejor caso).
✅ Se usan estructuras tipo cola o pila (Queue o Deque), ya que ofrece métodos optimizados como addFirst(), removeFirst(), addLast(), removeLast().
✅ Se realizan muchas eliminaciones en general, ya que cada eliminación en ArrayList requiere mover los elementos restantes, mientras que en LinkedList solo se ajustan punteros.

Ejemplo donde LinkedList es mejor:
*/

        List<Integer> lista2 = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            lista2.add(0, i);  // Inserta al inicio → O(1), en ArrayList sería O(n)
        }
        lista2.remove(50000);  // Rápido porque no hay que desplazar elementos

/*
c. ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y LinkedList?

    💾 Uso de memoria en ArrayList:
    Solo almacena los elementos en un array.
    Si el array se llena, se crea uno nuevo con el doble de capacidad, lo que puede causar desperdicio de memoria.

    💾 Uso de memoria en LinkedList:
    Cada elemento se almacena en un nodo que contiene:
        El valor
        Una referencia al nodo anterior
        Una referencia al nodo siguiente

    Esto aumenta el consumo de memoria, especialmente si hay muchos elementos.

    📌 Ejemplo visual
    Si almacenamos n enteros:
    ArrayList → Solo necesita espacio para n enteros.
    LinkedList → Necesita espacio para n enteros + 2 referencias por nodo (anterior y siguiente).

d. ¿En qué casos sería preferible usar un ArrayList o un LinkedList?

    📌 Regla general:

    Si necesitas acceso rápido a elementos y menos consumo de memoria, usa ArrayList.

    Si necesitas modificar frecuentemente el inicio o el medio de la lista, usa LinkedList.

 📌 Resumen final

    Usa ArrayList para acceso rápido y recorridos eficientes.

    Usa LinkedList para muchas inserciones/eliminaciones en el medio.

    ArrayList usa menos memoria, pero puede desperdiciarla cuando crece.

    LinkedList usa más memoria, pero evita movimientos de elementos.



    Catedra

    Respuestas:
		a. Cuando se accede a la estructura de modo directo.
		b. Cuando el tama;o de la estuctura varia constantemente.
		c. Para la misma cantidad de elementos la LinkedList usa mas espacio ya que necesita almacenar punteros.
		   Sin embargo, en un ArrayList es mas comun que se desperdicie espacio reservado.
		   Cuando en un ArrayList se quiere agregar un elemento y no hay mas espacio, java aumenta la dimension del
		   ArrayList en mas de uno, lo cual puede aumentar el rendimiento a costa de mas uso de memoria.
		d. Es preferible usar ArrayList cuando:
			-Se va a usar acceso directo.
			-No se necesita insertar o eliminar elementos de forma excesiva
		   Es preferible usar LinkedList cuando:
		    -Se va a recorrer la estructura de forma secuencial
		    -Se necesita insertar o eliminar elementos de forma excesiva
 */

    }
}