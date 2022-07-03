/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.access.users;

import libreria.libreria.model.domain.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Interfaz DaoUsuario - genera el repositorio para el Usuario
 *
 * @author Andrés David Muñoz
 */
public interface DAOUsuario extends JpaRepository<Usuario, Long> {
    /**
     * Encuentra un usuario por su username 
     * @param username 
     * @return Usuario 
     */
    Usuario findByUsername(String username);
    
    /**
     * Encuentra un usuario por su mail 
     * @param mail
     * @return Usuario 
     */
    Usuario findByMail(String mail); 
}
