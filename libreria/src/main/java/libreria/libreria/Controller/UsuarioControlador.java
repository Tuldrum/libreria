package libreria.libreria.Controller;

import javax.validation.Valid;
import libreria.libreria.model.domain.users.Usuario;
import libreria.libreria.model.service.users.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Mapea todo lo relacionado con el registro de usuarios 
 * @author Andrés David Muñoz 
 */
@Controller
@Slf4j
@RequestMapping("/registro")
public class UsuarioControlador {

    // atributos 
    @Autowired
    private UsuarioService userservice;

    /**
     * Retorna la vista de registro 
     * @param usuario 
     * @return "registro" view 
     */
    @GetMapping
    public String mostrarFormularioDeRegistro(Usuario usuario) {
        log.info("Retornar vista de registro");
	return "registro";
    }
    
    /**
     * Válida y guarda un usuario en el sistema 
     * @param user mapeado por desde la vista 
     * @param errors si hay campos vacíos o nulos
     * @param model atributos para la vista 
     * @return "redirect:/registro?state" si el registro fue fallido o exitoso, 
     * en el caso de contener campos vacíos o nulos, retorna "registro" view 
     */
    @PostMapping
    public String saveUser(@Valid Usuario user, Errors errors, Model model) {
        
        log.info("guardar un nuevo usuario");
        
        if (errors.hasErrors()) {
            return "registro";
        }
        if (userservice.saveUser(user)) {
            return "redirect:/registro?success";
        }
        return "redirect:/registro?failure";
    }

}
