package domain;
import java.sql.Date;
import lombok.Data;

@Data
public class Salarios {
   
    private int idSalario;
    private int  idTrabajador;
    private Date fechaPago;
    private float monto;
    private String periodo;
    
}
