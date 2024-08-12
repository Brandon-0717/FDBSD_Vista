package domain;

import java.util.ArrayList;
import java.util.List;

public class Listas {
    private static Listas instancia;
    
    // Listas para diferentes tipos de datos
    private List<Cliente> clientes;
    
    // Constructor privado para evitar instanciación externa
    private Listas() {
        clientes = new ArrayList<>();
    }
    
    // Método para obtener la instancia única de la clase
    public static synchronized Listas getInstancia() {
        if (instancia == null) {
            instancia = new Listas();
        }
        return instancia;
    }
    
    // Métodos para obtener y manipular las listas de clientes
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
    public void actualizarListaClientes(List<Cliente> nuevaLista) {
        // Limpiar la lista existente
        clientes.clear();
        
        // Agregar todos los clientes obtenidos de la nueva lista
        clientes.addAll(nuevaLista);
    }
    
}
