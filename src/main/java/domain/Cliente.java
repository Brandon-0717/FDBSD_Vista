package domain;
import lombok.Data;

@Data
public class Cliente {
   
    private int idCliente;
    private String nombreCliente;
    private String email;
    private String telefono;
    private int idTipoCliente;

}
