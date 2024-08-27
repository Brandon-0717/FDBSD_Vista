package model;

import controller.Conexion;
import domain.Departamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    private static final String SQL_SELECT = "SELECT id_departamento, nombre_departamento, encargado, descripcion FROM Departamentos";
    private static final String SQL_INSERT = "INSERT INTO Departamentos(nombre_departamento, encargado, descripcion) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "{CALL ActualizarDepartamento(?, ?, ?, ?)}";//PROCEDIMIENTO ALMACENADO
    private static final String SQL_DELETE = "DELETE FROM Departamentos WHERE id_departamento = ?";


    public void agregarDepartamento(Departamento departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setString(1, departamento.getNombreDepartamento()); // Primer parámetro
            ps.setString(2, departamento.getEncargado()); // Segundo parámetro
            ps.setString(3, departamento.getDescripcion()); // Tercer parámetro
            ps.executeUpdate(); // Ejecutar la consulta

            System.out.println("----Departamento agregado correctamente----");
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar un departamento");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(conn);
                Conexion.close(ps);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
    }

    public void actualizarDepartamento(Departamento departamento) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            CallableStatement stmt = conn.prepareCall(SQL_UPDATE);

            stmt.setInt(1, departamento.getIdDepartamento());      // Primer parámetro
            stmt.setString(2, departamento.getNombreDepartamento());      // Segundo parámetro
            stmt.setString(3, departamento.getEncargado());       // Tercer parámetro
            stmt.setString(4, departamento.getDescripcion());    // Cuarto parámetro

            stmt.executeUpdate(); // Ejecutar el procedimiento almacenado
            System.out.println("----Departamento actualizado correctamente----");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(conn); // Cerrar la conexión
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
    }

    public void eliminarDepartamento(Departamento departamento) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);

            ps.setInt(1, departamento.getIdDepartamento());

            ps.executeUpdate();
            System.out.println("----Departamento eliminado correctamente----");
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al eliminar");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(conn);
                Conexion.close(ps);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
    }
}
