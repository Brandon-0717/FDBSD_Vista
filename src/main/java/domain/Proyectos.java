package domain;
import java.sql.Date;
import lombok.Data;

@Data
public class Proyectos {
    private int idProyecto;
    private int idCliente;
    private String nombreProyecto;
    private Date fechaInicio;
    private Date fechaFin;
    private float presupuesto;
}
