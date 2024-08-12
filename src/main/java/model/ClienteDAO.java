package model;

import domain.*;
import controller.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre_cliente, email, telefono, id_tipoCliente FROM Clientes";
    private static final String SQL_INSERT = "INSERT INTO Clientes(nombre_cliente, email, telefono, id_tipoCliente) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE_CLIENTE = "{CALL ActualizarCliente(?, ?, ?, ?, ?)}";//PROCEDIMIENTO ALMACENADO
    private static final String SQL_DELETE = "DELETE FROM Clientes WHERE id_cliente = ?";

    public List<Cliente> listarClientes() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cliente = new Cliente(); //Crear un nuevo cliente por cada loop
                
                cliente.setIdCliente(rs.getInt("id_cliente")); //Agregar los datos obtenidos del rs al cliente creado
                cliente.setNombreCliente(rs.getString("nombre_cliente"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setIdTipoCliente(rs.getInt("id_tipoCliente"));
                
                clientes.add(cliente); //Agregar al cliente a la lista
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar usuarios");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(conn);
                Conexion.close(ps);
                Conexion.close(rs);
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setString(1, cliente.getNombreCliente()); // Primer parámetro
            ps.setString(2, cliente.getEmail()); // Segundo parámetro
            ps.setString(3, cliente.getTelefono()); // Tercer parámetro
            ps.setInt(4, cliente.getIdTipoCliente()); // Cuarto parámetro
            ps.executeUpdate(); // Ejecutar la consulta

            System.out.println("(\"----Cliente agregado correctamente(\"----");
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar un cliente");
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

    public void actualizarCliente(int idCliente, String nombre, String email, String telefono, int idTipoCliente) {
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            CallableStatement stmt = conn.prepareCall(SQL_UPDATE_CLIENTE);

            stmt.setInt(1, idCliente);      // Primer parámetro
            stmt.setString(2, nombre);      // Segundo parámetro
            stmt.setString(3, email);       // Tercer parámetro
            stmt.setString(4, telefono);    // Cuarto parámetro
            stmt.setInt(5, idTipoCliente);  // Quinto parámetro

            stmt.executeUpdate(); // Ejecutar el procedimiento almacenado
            System.out.println("(\"----Cliente actualizado correctamente(\"----");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(conn); // Cerrar la conexion
            } catch (SQLException e) {
                System.out.println("Ocurrió un error al cerrar conexión");
            }
        }
    }

    public void eliminarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);

            ps.setInt(1, cliente.getIdCliente());

            ps.executeUpdate();
            System.out.println("----Cliente eliminado correctamente----");
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
