package controller;

import java.sql.*;

public class Conexion {

    private static final String URL_JDBC = "jdbc:sqlserver://localhost:1433;databaseName=FDBSD_Proyecto;encrypt=false;";
    private static final String JDBC_USER = "user1";
    private static final String JDBC_PASSWORD = "password";
    private static Conexion instancia;

    /*private Conexion() {
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }*/

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL_JDBC, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();

    }

    public static void close(Statement stmt) throws SQLException {
        stmt.close();

    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
