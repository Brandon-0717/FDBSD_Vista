package model;

import controller.Conexion;
import domain.Proveedores;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProveedoresDAO {
    
    private static final String SQL_SELECT = "SELECT id_proveedor, nombre_proveedor, direccion, telefono, email, id_tipoProveedor FROM Proveedores";
    private static final String SQL_INSERT = "{CALL InsertarProveedor(?, ?, ?, ?, ?)}";//PROCEDIMIENTO ALMACENADO
    private static final String SQL_UPDATE = "UPDATE Proveedores SET nombre_proveedor = ?, direccion = ?, telefono = ?, email = ?, id_tipoProveedor = ? WHERE id_proveedor = ?";
    private static final String SQL_DELETE = "DELETE FROM Proveedores WHERE id_proveedor = ?";
     
    public void agregarProveedor(Proveedores proveedor) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            CallableStatement stmt = conn.prepareCall(SQL_INSERT);

            stmt.setString(1, proveedor.getNombreProveedor());
            stmt.setString(2, proveedor.getDireccion()); // Segundo parámetro
            stmt.setString(3, proveedor.getTelefono()); // Tercer parámetro
            stmt.setString(4, proveedor.getEmail()); // Cuarto parámetro
            stmt.setInt(5, proveedor.getIdTipoProveedor());  // Quinto parámetro
            stmt.executeUpdate(); // Ejecutar la consulta

            System.out.println("----Proveedor agregado correctamente----");
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar un proveedor");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(conn);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
    }

    public void actualizarProveedor(Proveedores proveedor) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, proveedor.getNombreProveedor());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getEmail());
            ps.setInt(5, proveedor.getIdTipoProveedor());
            ps.setInt(6, proveedor.getIdProveedor());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al actualizar un proveedor");
        }
        finally{
            try {
                Conexion.close(conn);
                Conexion.close(ps);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
    }

    public void eliminarProveedor(Proveedores proveedor) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);

            ps.setInt(1, proveedor.getIdProveedor());

            ps.executeUpdate();
            System.out.println("----Proveedor eliminado correctamente----");
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
