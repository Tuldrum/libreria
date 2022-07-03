package libreria.libreria.model.domain.users;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * class Usuario - mapea un objeto de la clase Car respecto a la tabla respectiva en 
 * la base de datos 
 * @author Andrés David Muñoz
 */
@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //atributos 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id_usuario;

    @NotEmpty
    @Column(name = "usr")
    private String username;

    @NotEmpty
    @Column(name = "pwd")
    private String password;
    
    @NotEmpty
    @Column(name = "name")
    private String nombre;
    
    @NotEmpty
    @Column(name = "mail")
    private String mail;
  
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "id_user",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_rol",referencedColumnName = "id")
        )
    private List<Rol> roles;
}
