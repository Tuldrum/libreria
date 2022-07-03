/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.service.users;
import java.util.List;
import libreria.libreria.model.access.users.DAORol;
import libreria.libreria.model.domain.users.Rol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@EnableTransactionManagement
public class ServiceRol implements IServiceRol{
    
    @Autowired 
    private DAORol repo;  
    
    @Override
    @Transactional(value="userTransactionManager", readOnly=true)
    public Rol find(String name) {
        return repo.findByNombre(name);  
    }

    @Override
    @Transactional(value="userTransactionManager", readOnly=true)
    public List<Rol> list(){
        return repo.findAll();  
    }
    
}
