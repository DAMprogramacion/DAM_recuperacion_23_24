package RA8_y_RA9.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //patrón Singleton
    private static Conexion conexion = null;
    private Connection connection;

    //constructor privado
    private Conexion(){
        //inicializamos la conexión
        String url = "jdbc:sqlite:DB/data.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //getInstance para devolver conexion
    public static Conexion getInstance(){
        if (conexion == null)
            conexion = new Conexion();
        return conexion;
    }
    //getter para devolver connection

    public Connection getConnection() {
        return connection;
    }
}
