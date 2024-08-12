package model;

import domain.*;
import controller.*;
import model.*;
import java.sql.*;
import java.util.List;

public class Gestion {

    Conexion c = new Conexion();

    public void mostrar() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establecer la conexión
            connection = c.getConnection();
            System.out.println("Conexión establecida con éxito.");

            // Crear un statement y ejecutar una consulta
            statement = connection.createStatement();
            String query = "SELECT * FROM VistaProyectosPorCliente";
            resultSet = statement.executeQuery(query);

            // Mostrar los resultados de la consulta
            while (resultSet.next()) {
                int idCliente = resultSet.getInt("id_cliente");
                String nombreCliente = resultSet.getString("nombre_cliente");
                int idProyecto = resultSet.getInt("id_proyecto");
                String nombreProyecto = resultSet.getString("nombre_proyecto");
                Date fechaInicio = resultSet.getDate("fecha_inicio");
                Date fechaFin = resultSet.getDate("fecha_fin");
                Double presupuesto = resultSet.getDouble("presupuesto");

                System.out.println("ID Cliente: " + idCliente + ", Nombre Cliente: " + nombreCliente
                        + ", ID Proyecto: " + idProyecto + ", Nombre Proyecto: " + nombreProyecto
                        + ", Fecha Inicio: " + fechaInicio + ", Fecha Fin: " + fechaFin
                        + ", Presupuesto: " + presupuesto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void agregar() {
        ClienteDAO cd = new ClienteDAO();

        Cliente cl = new Cliente();
        cl.setIdCliente(4);
        cl.setNombreCliente("Brandon Aguirre");
        cl.setEmail("ba@gmail.com");
        cl.setTelefono("7226-9255");
        cl.setIdTipoCliente(3);

        cd.eliminarCliente(cl);
    }

    public void listar() {
        ClienteDAO cd = new ClienteDAO();
        // Obtener la lista actualizada de clientes desde la base de datos
        List<Cliente> clientes = cd.listarClientes();

        // Obtener la instancia única de Listas
        Listas listas = Listas.getInstancia();

        // Actualizar la lista de clientes en el singleton
        listas.actualizarListaClientes(clientes);

        if (listas.getClientes().isEmpty()) {
            System.out.println("No hay clientes para mostrar.");
        } else {
            for (Cliente cliente : listas.getClientes()) {
                System.out.println("ID Cliente: " + cliente.getIdCliente());
                System.out.println("Nombre: " + cliente.getNombreCliente());
                System.out.println("Email: " + cliente.getEmail());
                System.out.println("Teléfono: " + cliente.getTelefono());
                System.out.println("ID Tipo Cliente: " + cliente.getIdTipoCliente());
                System.out.println("-----------------------------");
            }
        }
    }
}
