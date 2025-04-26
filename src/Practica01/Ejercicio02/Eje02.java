/*
Escriba un metodo de clase que dado un número n devuelva un nuevo arreglo de tamaño n
con los n primeros múltiplos enteros de n mayores o iguales que 1.

Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}

Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por
teclado, mediante el uso de System.in. La clase Scanner permite leer de forma sencilla
valores de entrada.
 */

package Practica01.Ejercicio02;

import java.util.Scanner;

public class Eje02 {

    public static void main(String[] args) {

        int[] multiplos;
        System.out.print("Ingrese 'n': ");
        Scanner scanner  = new Scanner(System.in);
        multiplos = Contador.multiplos(scanner.nextInt());
        System.out.print("El arreglo de multiplos generado es: ");
        for (int n : multiplos) {
            System.out.print(n + " ");
        }
    }
}