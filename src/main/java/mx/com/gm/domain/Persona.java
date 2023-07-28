package mx.com.gm.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

@Data //Java Bean geters y seters
@Entity //clases de entidad
@Table(name = "persona") //corregir errores de mayus y min en BD y clase
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id //llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generar el id automatico
    private Long idPersona;
    
    @NotEmpty //validacion para que no sea nulo
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email//validacion tipo email
    private String email;
    private String telefono;
}
