package Practica01.Ejercicio03;

public class Test {

    public static void main(String[] args) {

        Estudiante[] estudiantes = new Estudiante[2];
        Profesor[] profesores = new Profesor[3];

        estudiantes[0] = new Estudiante("Manuel", "Gomez", "ManuGo@gmail.com", "Comisión 2", "Calle 4");
        estudiantes[1] = new Estudiante("Raul", "Perez", "Rape@gmail.com", "Comisión 6", "Calle 8");
        profesores[0] = new Profesor("Franco", "Benitez", "Frabe@gmail.com", "Cátedra 2", "Calle 9");
        profesores[1] = new Profesor("Joaquín", "Mendez", "JoaMe@gmail.com", "Cátedra 6", "Calle 12");
        profesores[2] = new Profesor("Matías", "Muzzuzupappa", "MaMu@gmail.com", "Cátedra 5", "Calle 21");

        for (Estudiante e : estudiantes) {
            System.out.println(e.tusDatos());
        }
        for (Profesor p : profesores) {
            System.out.println(p.tusDatos());
        }
    }
}