/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.service.data;

import libreria.libreria.model.access.data.DAOCarItems;
import libreria.libreria.model.domain.data.Car;
import libreria.libreria.model.domain.data.Libro;
import libreria.libreria.model.domain.data.car_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */

@Service
@EnableTransactionManagement
public class ServiceCarItem implements IServiceCarItem{

    @Autowired 
    private DAOCarItems repo;  
    
    
    @Override
    @Transactional(value="DataTransactionManager")
    public void save(car_items item) {
        repo.save(item);  
    }
    
    @Override
    @Transactional(value="DataTransactionManager")
    public void delete(car_items item) {
        repo.delete(item);
    }

    @Override
    @Transactional(value="DataTransactionManager", readOnly=true)
    public car_items get(car_items item) {
        return repo.findById(item.getId()).orElse(null);
    }
    
    @Override
    @Transactional(value="DataTransactionManager", readOnly=true)
    public car_items findByCarItemANDLibroItem(Long car_id,Long libro_id ) {
        Car car = new Car();  
        car.setId(car_id);
        
        Libro libro = new Libro();  
        libro.setId(libro_id);
        
        return repo.findByCarItemAndLibroItem(car , libro );
    }

    @Override
    @Transactional(value="DataTransactionManager")
    public boolean deleteByLibro(Libro libro) {
        repo.deleteByLibroItem(libro); 
        return true; 
    }
}
