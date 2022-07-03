/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.service.data;

import java.util.List;
import libreria.libreria.model.access.data.DAOLibro;
import libreria.libreria.model.domain.data.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * class ServiceLibro  
 * @author Andrés David Muñoz 
 */
@Service
@EnableTransactionManagement
public class ServiceLibro implements IServiceLibro{
    
    //atributos 
    @Autowired 
    private DAOLibro daoLibro; 
    
    //métodos 
    
    @Transactional(value="DataTransactionManager", readOnly=true)
    @Override
    public Libro get(Libro lb) {
        return daoLibro.findById(lb.getId()).orElse(null);  
    }

    @Transactional(value="DataTransactionManager")
    @Override
    public void delete(Libro lb) {
        daoLibro.delete(lb);
    }
    
    @Transactional(value="DataTransactionManager")
    @Override
    public void save(Libro lb) {
        daoLibro.save(lb);
    }
    
    @Transactional(value="DataTransactionManager", readOnly=true)
    @Override
    public List<Libro> list() {
        return daoLibro.findAll();
    }
    
}
