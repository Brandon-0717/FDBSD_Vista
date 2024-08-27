package model;

import controller.Conexion;
import domain.Proyectos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProyectosDAO {
    private static final String SQL_SELECT = "SELECT id_proyecto, id_cliente, nombre_proyecto, fecha_inicio, fecha_fin, presupuesto FROM Proyectos";
    private static final String SQL_INSERT = "INSERT INTO Proyectos(id_cliente, nombre_proyecto, fecha_inicio, fecha_fin, presupuesto) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Proyectos SET nombre_proyecto = ?, fecha_inicio = ?, fecha_fin = ?, presupuesto = ? WHERE id_usuario = ?";  
    private static final String SQL_DELETE = "DELETE FROM Proyectos WHERE id_proyecto = ?";
    
    public void agregarProyecto(Proyectos proyecto){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            
            ps.setInt(1, proyecto.getIdCliente());
            ps.setString(2, proyecto.getNombreProyecto());
            ps.setDate(3, proyecto.getFechaInicio());
            ps.setDate(4, proyecto.getFechaFin());
            ps.setFloat(5, proyecto.getPresupuesto());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar un Proyecto");
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
    
    public void actualizarUsuario(Proyectos proyecto){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            
            ps.setInt(1, proyecto.getIdCliente());
            ps.setString(2, proyecto.getNombreProyecto());
            ps.setDate(3, proyecto.getFechaInicio());
            ps.setDate(4, proyecto.getFechaFin());
            ps.setFloat(5, proyecto.getPresupuesto());
            ps.setInt(6, proyecto.getIdProyecto());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al actualizar un proyecto");
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
    
    public void eliminarUsuario(Proyectos proyecto){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            
            ps.setInt(1, proyecto.getIdProyecto());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al eliminar");
            
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
}
