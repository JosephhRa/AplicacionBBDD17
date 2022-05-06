package Aplicacion;

import Controlador.ConexionMySql;
import Controlador.Gestionador;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        System.out.println("BIENVENIDO AL EDITOR DE BASES DE DATOS!");
        System.out.println(">Escoja una opción:");
        System.out.println("1. Ingresar datos");
        System.out.println("2. Consulta general");
        System.out.println("3. Consultar dato determinado");
        System.out.println("4. Actualización de registro");
        System.out.println("5. Eliminacion de registro");
        System.out.println("0. Salir de la aplicación");
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
                //gestionador.salir();
            }
            case 1 -> {
                //gestionador.ingresarDatos();
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
                //actualizacionRegistro()
            }
            case 5 -> {
                //eliminacionRegistro()
            }

        }
    }
}
