package model;

import controller.Conexion;
import domain.Trabajador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TrabajadoresDAO {
    
    private static final String SQL_SELECT = "SELECT id_trabajador, id_departamento, nombre_trabajador, apellido_1, apellido_2, cedula, telefono, email FROM Trabajadors";
    private static final String SQL_INSERT = "INSERT INTO Trabajadores(id_departamento, nombre_trabajador, apellido_1, apellido_2, cedula, telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Trabajadores SET nombre_trabajador = ?, apellido_1 = ?, apellido_2 = ?, cedula = ?, telefono = ? , email = ? WHERE id_proveedor = ?";
    private static final String SQL_DELETE = "{CALL EliminarTrabajador(?)}";//PROCEDIMIENTO ALMACENADO

    public void agregarTrabajador(Trabajador trabajador) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setInt(1, trabajador.getIdDepartamento()); // Primer parámetro
            ps.setString(2, trabajador.getNombreTrabajador()); // Segundo parámetro
            ps.setString(3, trabajador.getApellido1()); // Tercer parámetro
            ps.setString(4, trabajador.getApellido2()); // Cuarto parámetro
            ps.setString(5, trabajador.getCedula()); // Quinto parámetro
            ps.setString(6, trabajador.getTelefono()); // Sexto parámetro
            ps.setString(7, trabajador.getEmail()); // Septimo parámetro
            ps.executeUpdate(); // Ejecutar la consulta

            System.out.println("----Trabajador agregado correctamente----");
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar un trabajador");
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

    public void actualizarTrabajador(Trabajador trabajador) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            CallableStatement stmt = conn.prepareCall(SQL_UPDATE);

            stmt.setInt(1, trabajador.getIdTrabajador());      // Primer parámetro
            stmt.setInt(2, trabajador.getIdDepartamento());      // Segundo parámetro
            stmt.setString(3, trabajador.getNombreTrabajador());       // Tercer parámetro
            stmt.setString(4, trabajador.getApellido1());    // Cuarto parámetro
            stmt.setString(5, trabajador.getApellido2());  // Quinto parámetro
            stmt.setString(6, trabajador.getCedula()); //Sexto parámetro
            stmt.setString(7, trabajador.getTelefono()); // Septimo parámetro
            stmt.setString(8, trabajador.getEmail()); // Octavo parámetro

            stmt.executeUpdate(); 
            System.out.println("----Trabajador actualizado correctamente----");
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

    public void eliminarTrabajador(Trabajador trabajador) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            CallableStatement stmt = conn.prepareCall(SQL_DELETE);

            stmt.setInt(1, trabajador.getIdTrabajador());
    
            stmt.executeUpdate(); 
            System.out.println("----Trabajador eliminado correctamente----");
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
}
