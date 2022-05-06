package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {
    public Connection conectar () {
        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/world", //url
                    "root", //user xd
                    "" //password
            );

            if (con != null) {
                System.out.println("[Conectado]");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public void desconectar (Connection con) {
        try {
            con.close();
            System.out.println("[Desconectado]");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
