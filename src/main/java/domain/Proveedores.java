package domain;
import lombok.Data;

@Data
public class Proveedores {
    
    private int idProveedor;
    private String nombreProveedor;
    private String direccion;
    private String telefono;
    private String email;
    private int idTipoProveedor;
}
