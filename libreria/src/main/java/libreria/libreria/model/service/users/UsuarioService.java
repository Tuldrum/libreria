package libreria.libreria.model.service.users;

import java.util.ArrayList;
import java.util.List;
import libreria.libreria.model.access.users.DAOUsuario;
import libreria.libreria.model.domain.data.Car;
import libreria.libreria.model.domain.users.Rol;
import libreria.libreria.model.domain.users.Usuario;
import libreria.libreria.model.service.data.ServiceCar;
import libreria.libreria.model.utils.EncriptarPassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


/**
 * class UsuarioService
 * @author Andrés David Muñoz
 */
@Service("userDetailsService")
@Slf4j
@EnableTransactionManagement
public class UsuarioService implements UserDetailsService {
    
    //variables 
    @Autowired 
    private DAOUsuario iusuario;   
    
    @Autowired
    private ServiceRol serviceRol;  
    
    @Autowired
    private ServiceCar serviceCar;  
    
    /**
     * busca un usuario por su username 
     * @param username
     * @return Usuario 
     */
    @Transactional(value="userTransactionManager", readOnly=true)
    public Usuario buscarUsuario(String username){
        return iusuario.findByUsername(username); 
    }
    
    /**
     * busca un usuario por su mail 
     * @param mail
     * @return Usuario
     */
    @Transactional(value="userTransactionManager", readOnly=true)
    public Usuario buscarUsuarioMail(String mail){
        return iusuario.findByMail(mail); 
    }
    
    /**
     * Genera un usuario para la sesión 
     * @param username
     * @return User
     * @throws UsernameNotFoundException 
     */
    @Override
    @Transactional(value="userTransactionManager", readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = buscarUsuario(username); 
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        ArrayList roles = new ArrayList<GrantedAuthority>(); 
        
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombre()));  
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);             
    }
    
    /**
     * Guarda un nuevo usuario en el sistema 
     * @param user
     * @return boolean 
     */
    @Transactional(value="userTransactionManager")
    public boolean saveUser(Usuario user){
        if(buscarUsuario(user.getUsername()) != null || buscarUsuarioMail(user.getMail()) != null){
            return false;  
        }
        user.setPassword(EncriptarPassword.encriptarPassword(user.getPassword()));
        List<Rol> roles = new ArrayList();  
        roles.add(serviceRol.find("NO ADMIN"));  
        user.setRoles(roles);
        iusuario.save(user);  
        asignarCarrito(user);  
        return true;  
    }
    
    private void asignarCarrito(Usuario user){
        user = iusuario.findByUsername(user.getUsername()); 
        Car  car  = new Car(); 
        car.setUserId(user.getId_usuario());
        serviceCar.save(car); 
    }
    
}
