package domain;
import lombok.Data;

@Data
public class Departamento {
    private int idDepartamento;
    private String nombreDepartamento;
    private String encargado;
    private String descripcion;
}
