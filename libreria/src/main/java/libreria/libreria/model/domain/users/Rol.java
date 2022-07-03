package libreria.libreria.model.domain.users;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


/**
 * class Rol - mapea un objeto de la clase Rol respecto a la tabla respectiva en 
 * la base de datos 
 * @author Andrés David Muñoz
 */
@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //Atributos 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idRol;

    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
        
}
