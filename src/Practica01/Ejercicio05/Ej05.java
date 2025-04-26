/*
Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único metodo. Escriba tres métodos de clase, donde respectivamente:

a. Devuelva lo pedido por el mecanismo de retorno de un metodo en Java ("return").

b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).

c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".
 */

package Practica01.Ejercicio05;

public class Ej05 {

    public static void main(String[] args) {

        Registro registro = new Registro (0, 0, 0);
        int[] enteros = new int[10];
        for (int i = 0; i < enteros.length; i++) {
            enteros[i] = i + 1;
        }

        registro = Calcular.MetodoA(enteros);
        System.out.println(registro.toString());

        Calcular.MetodoB(enteros, registro);
        System.out.println(registro.toString());

        Calcular.MetodoC(enteros);
        System.out.println(Calcular.getRegistro().toString());


    }
}
