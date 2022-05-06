package Aplicacion;

import Controlador.ConexionMySql;
import Controlador.Gestionador;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Gestionador tabla = new Gestionador();

        tabla.insertarDatos("countrylanguage");
    }
    //xdd
}
