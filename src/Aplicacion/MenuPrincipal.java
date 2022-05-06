package Aplicacion;

import Controlador.ConexionMySql;
import Controlador.Gestionador;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("BIENVENIDO AL EDITOR DE BASES DE DATOS!");
        System.out.println("---------------------------------------------------");
        System.out.println(">Escoja una opción:");
        System.out.println(" >1. Ingresar datos");
        System.out.println(" >2. Consulta general");
        System.out.println(" >3. Consultar dato determinado");
        System.out.println(" >4. Actualización de registro");
        System.out.println(" >5. Eliminacion de registro");
        System.out.println(" >0. Salir de la aplicación");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escojo: ");
        int opcion = scanner.nextInt();
        while (opcion > 5) {
            System.out.println("Elije un valor dentro del rango!!");
            System.out.println("Escojo: ");
            opcion = scanner.nextInt();
        }

        Gestionador gestionador = new Gestionador();

        switch (opcion) {
            case 0 -> {
                salirDeAplicacion();
            }
            case 1 -> {
                System.out.println("Introduce la tabla en la que insertar");
                String nombreTabla = scanner.next();
                gestionador.insertarDatos(nombreTabla);
            }
            case 2 -> {
                System.out.println("Introduce una tabla a consultar");
                String nombreTabla = scanner.next();
                gestionador.consultaGeneral(nombreTabla);
            }
            case 3 -> {
                System.out.println("Introduce una tabla a consultar");
                String nombreTabla = scanner.next();
                System.out.println("Introduce el dato a seleccionar");
                String dato = scanner.next();
                gestionador.consultarDatoDeterminado(dato, nombreTabla);
            }
            case 4 -> {
                System.out.println("Introduce la tabla a modificar");
                String nombreTabla = scanner.next();
                gestionador.update(nombreTabla);
            }
            case 5 -> {
                System.out.println("Introduce una tabla a consultar");
                String nombreTabla = scanner.next();
                System.out.println("Introduce la/las claves primarias (separar con comas y sin espacios si son varias Ej: ABW,Dutch )");
                String claves = scanner.next();
                gestionador.eliminar(nombreTabla, claves);
            }

        }
    }

    public static void salirDeAplicacion(){
        System.exit(0);
    }
}
