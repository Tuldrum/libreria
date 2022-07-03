/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.service.data;

import libreria.libreria.model.access.data.DAOCar;
import libreria.libreria.model.domain.data.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interfaz ServiceCar - genera el repositorio para el carrito de compras
 *
 * @author Andrés David Muñoz
 */

@Service 
@EnableTransactionManagement
public class ServiceCar implements IServiceCar {
    
    @Autowired
    private DAOCar carRepo; 
        
    @Override
    @Transactional(value="DataTransactionManager")
    public boolean save(Car car) {
        carRepo.save(car);  
        return true;  
    }

    @Override
    @Transactional(value="DataTransactionManager")
    public boolean delete(Car car) {
        carRepo.delete(car);
        return true; 
    }

    @Override
    @Transactional(value="DataTransactionManager", readOnly=true)
    public Car find(Long user_id){
        return carRepo.findByUserId(user_id);    
    }
    
}
