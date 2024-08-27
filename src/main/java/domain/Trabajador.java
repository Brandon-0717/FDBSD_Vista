package domain;
import lombok.Data;

@Data
public class Trabajador {
    private int idTrabajador;
    private int idDepartamento;
    private String nombreTrabajador;
    private String apellido1;
    private String apellido2;
    private String cedula;
    private String telefono;
    private String email;
}
