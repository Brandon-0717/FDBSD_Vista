package model;

import controller.Conexion;
import domain.Salarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalariosDAO {
    
    private static final String SQL_SELECT = "SELECT id_salario, id_trabajador, fecha_pago, monto, periodo FROM Salarios";
    private static final String SQL_INSERT = "INSERT INTO Salarios (id_trabajador, fecha_pago, monto, periodo) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "{CALL ActualizarSalario(?, ?)}";//PROCEDIMIENTO ALMACENADO
    private static final String SQL_DELETE = "DELETE FROM Salarios WHERE id_salario = ?";
    
     public void agregarSalario(Salarios salario) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setInt(1, salario.getIdTrabajador()); // Segundo parámetro
            ps.setDate(2, salario.getFechaPago()); // Tercer parámetro
            ps.setFloat(3, salario.getMonto()); // Cuarto parámetro
            ps.setString(4, salario.getPeriodo()); // Quinto parámetro
            
            ps.executeUpdate(); // Ejecutar la consulta

            System.out.println("----Salario agregado correctamente----");
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar un Salario");
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

    public void actualizarSalario(Salarios salario) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            CallableStatement stmt = conn.prepareCall(SQL_UPDATE);

            stmt.setInt(1, salario.getIdSalario());      // Primer parámetro
            stmt.setFloat(2, salario.getMonto());      // Segundo parámetro
           
            stmt.executeUpdate(); // Ejecutar el procedimiento almacenado
            System.out.println("----Salario actualizado correctamente----");
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

    public void eliminarSalario(Salarios salario) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);

            ps.setInt(1, salario.getIdSalario());

            ps.executeUpdate();
            System.out.println("----Salario eliminado correctamente----");
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
