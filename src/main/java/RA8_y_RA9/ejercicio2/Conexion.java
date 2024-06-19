package RA8_y_RA9.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion conexion;
    private Connection connection;
    private Conexion() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:DB/data1.db");
    }
    public static Conexion getInstance() throws SQLException {
        if (conexion == null)
            conexion = new Conexion();
        return conexion;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getInstance().getConnection());
        System.out.println(getInstance().getConnection());
    }
}
