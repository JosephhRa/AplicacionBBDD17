package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Gestionador {

    public void insertarDatos(String nombreTabla){

        Scanner scan = new Scanner(System.in);
        ConexionMySql conexion = new ConexionMySql();
        Connection con = conexion.conectar();
        try {

                Statement statement = con.createStatement();
                if (nombreTabla.equals("city")) {
                             System.out.println("Ingrese el id");
                             int id = scan.nextInt();
                             System.out.println("Ingrese el nombre");
                             String name = scan.next();
                             System.out.println("Ingrese el código de la ciudad");
                             String countrycode = scan.next();
                             System.out.println("Ingrese el distrito");
                             String district = scan.next();
                             System.out.println("Ingrese la población");
                             int population = scan.nextInt();
                     String datos = String.format("VALUES (%s, \"%s\", \"%s\", \"%s\", %s)",id,name,countrycode,district,population);

                    statement.execute("INSERT INTO"+ " " + nombreTabla+ "(id,name,countrycode,district,population)"+ " " + datos);
                }else if (nombreTabla.equals("country")){

                            System.out.println("Ingrese el código");
                            String code = scan.next();
                            System.out.println("Ingrese el nombre");
                            String name = scan.next();
                            System.out.println("Ingrese el continente");
                            String continent = scan.next();
                            System.out.println("Ingrese la región");
                            String region = scan.next();
                            System.out.println("Ingrese la surfacearea");
                            int surfacearea = scan.nextInt();
                            System.out.println("Ingrese el año de independencia");
                            int indepyear = scan.nextInt();
                            System.out.println("Ingrese la población");
                            int population = scan.nextInt();
                            System.out.println("Ingrese la esperanza de vida");
                            int lifeexpectancy = scan.nextInt();
                            System.out.println("Ingrese el GNP");
                            int gnp = scan.nextInt();
                            System.out.println("Ingrese el GNPOld");
                            int gnpold = scan.nextInt();
                            System.out.println("Ingrese el nombre local");
                            String localname = scan.next();
                            System.out.println("Ingrese la forma de gobierno");
                            String governmentform = scan.next();
                            System.out.println("Ingrese la cabeza de estado");
                            String headofstate = scan.next();
                            System.out.println("Ingrese la capital");
                            int capital = scan.nextInt();
                            System.out.println("Ingrese el code2");
                            String code2 = scan.next();

                    String datos = String.format("VALUES (\"%s\",\"%s\",\"%s\",\"%s\",%s,%s,%s,%s,%s,%s,\"%s\",\"%s\",\"%s\",%s,\"%s\")",code,name,continent,
                                    region,surfacearea,indepyear,population,lifeexpectancy,gnp,gnpold,localname,governmentform,headofstate,capital,code2);

                             statement.execute("INSERT INTO"+ " " +nombreTabla+"(code,name,continent," +
                                     "region,surfacearea,indepyear,population,lifeexpectancy,gnp,gnpold,localname," +
                                     "governmentform,headofstate,capital,code2)"+ " " + datos);

                }else if(nombreTabla.equals("countrylanguage")){

                            System.out.println("Ingrese el countrycode");
                            String countrycode = scan.next();
                            System.out.println("Ingrese el lenguaje");
                            String language = scan.next();
                            System.out.println("Ingrese si el leguaje es oficial");
                            String isofficial = scan.next();
                            Boolean.parseBoolean(isofficial);
                            System.out.println("Ingrese el porcentaje");
                            String percentage = scan.next();
                            String datos = String.format("VALUES(\"%s\",\"%s\",\"%s\",%s)", countrycode,language,isofficial,percentage);
                            statement.execute("INSERT INTO"+ " " +nombreTabla+"(countrycode,language,isofficial,percentage)"+ " " +datos);
                }
        } catch (SQLException e) {
            System.err.println("Error al insertar");
            e.printStackTrace();
        }finally{
            conexion.desconectar(con);
        }
    }

    public void update(String nombreTabla){

        ConexionMySql conexion = new ConexionMySql();
        Connection con = conexion.conectar();
        Scanner scan = new Scanner(System.in);
        try{
            Statement statement = con.createStatement();

            if (nombreTabla.equals("city")){

                System.out.println("Escoja los datos que desea modificar.");
                System.out.println("Presione 1 para cambiar el nombre de la tabla.\nPresione 2 para cambiar el distrito." +
                                    "\nPresione 3 para cambiar la población.\nPresione 4 para cambiar todos los datos.");
                int cambios;
                cambios = scan.nextInt();

                if (cambios == 1){
                    System.out.println("Ingrese el id");
                    int id = scan.nextInt();
                    System.out.println("Ingrese el nombre");
                    String name = scan.next();

                    statement.execute("UPDATE "+ " " + nombreTabla + " SET name = '" +name+ "" +
                                         "' WHERE id = '"+id+"'");
                }else if (cambios == 2){
                    System.out.println("Ingrese el id");
                    int id = scan.nextInt();
                    System.out.println("Ingrese el distrito");
                    String district = scan.next();

                    statement.execute("UPDATE "+ " " + nombreTabla + " SET District= '"
                                        +district+"' WHERE id = '"+id+"'");

                }else if (cambios == 3){
                    System.out.println("Ingrese el id");
                    int id = scan.nextInt();
                    System.out.println("Ingrese la población");
                    int population = scan.nextInt();

                    statement.execute("UPDATE "+ " " + nombreTabla + " SET Population= '"
                                         +population+"' WHERE id = '"+id+"'");
                }else if (cambios == 4) {

                    System.out.println("Ingrese el id");
                    int id = scan.nextInt();
                    System.out.println("Ingrese el nombre");
                    String name = scan.next();
                    System.out.println("Ingrese el distrito");
                    String district = scan.next();
                    System.out.println("Ingrese la población");
                    int population = scan.nextInt();

                    statement.execute("UPDATE " + " " + nombreTabla + " SET name = '" + name + "', District= '"
                            + district + "', Population= '" + population + "' WHERE id = '" + id + "'");
                }
            }else if(nombreTabla.equals("country")){

                System.out.println("Ingrese el código");
                String code = scan.next();
                System.out.println("Ingrese el nombre");
                String name = scan.next();
                System.out.println("Ingrese el continente");
                String continent = scan.next();
                System.out.println("Ingrese la región");
                String region = scan.next();
                System.out.println("Ingrese la surfacearea");
                int surfacearea = scan.nextInt();
                System.out.println("Ingrese el año de independencia");
                int indepyear = scan.nextInt();
                System.out.println("Ingrese la población");
                int population = scan.nextInt();
                System.out.println("Ingrese la esperanza de vida");
                int lifeexpectancy = scan.nextInt();
                System.out.println("Ingrese el GNP");
                int gnp = scan.nextInt();
                System.out.println("Ingrese el GNPOld");
                int gnpold = scan.nextInt();
                System.out.println("Ingrese el nombre local");
                String localname = scan.next();
                System.out.println("Ingrese la forma de gobierno");
                String governmentform = scan.next();
                System.out.println("Ingrese la cabeza de estado");
                String headofstate = scan.next();
                System.out.println("Ingrese la capital");
                int capital = scan.nextInt();
                System.out.println("Ingrese el code2");
                String code2 = scan.next();

            }

        } catch (SQLException e) {
            System.err.println("Error al editar");
            e.printStackTrace();
        }finally{
            conexion.desconectar(con);
        }

    }



    /***********ALBA xd**********/
    public void consultaGeneral (String nombreTabla) {
        ConexionMySql conexion = new ConexionMySql();
        Connection con = conexion.conectar();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + nombreTabla);

            System.out.println("-- DATOS DE TABLA " + nombreTabla.toUpperCase() + " --");
            while (rs.next()) {
                if (nombreTabla.equals("city")) {
                    System.out.println("ID: " + rs.getString("ID") +
                            " | Name: " + rs.getString("Name") +
                            " | CountryCode: " + rs.getString("CountryCode") +
                            " | District: " + rs.getString("District") +
                            " | Population: " + rs.getString("Population"));

                } else if (nombreTabla.equals("country")) {
                    System.out.println("Code: " + rs.getString("Code") +
                            " | Name: " + rs.getString("Name") +
                            " | Continent: " + rs.getString("Continent") +
                            " | Region: " + rs.getString("Region") +
                            " | SurfaceArea: " + rs.getString("SurfaceArea") +
                            " | Population: " + rs.getString("Population") +
                            " | LifeExpectancy: " + rs.getString("LifeExpectancy") +
                            " | GNP: " + rs.getString("GNP") +
                            " | GNPOld: " + rs.getString("GNPOld") +
                            " | LocalName: " + rs.getString("LocalName") +
                            " | GovernmentForm: " + rs.getString("GovernmentForm") +
                            " | HeadOfState: " + rs.getString("HeadOfState") +
                            " | Capital: " + rs.getString("Capital") +
                            " | Code2: " + rs.getString("Code2"));
                } else if (nombreTabla.equals("countrylanguage")) {
                    System.out.println(
                            " | CountryCode: " + rs.getString("CountryCode") +
                                    " | Language: " + rs.getString("Language") +
                                    " | IsOfficial: " + rs.getString("IsOfficial") +
                                    " | Percentage: " + rs.getString("Percentage"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar(con);
        }
    }

    public void consultarDatoDeterminado (String dato, String tabla) {
        ConexionMySql conexion = new ConexionMySql();
        Connection con = conexion.conectar();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(String.format("SELECT `%s` FROM %s",dato, tabla));

            while (rs.next()) {
                System.out.println(dato + ": " + rs.getString(dato));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            conexion.desconectar(con);
        }
    }

}
