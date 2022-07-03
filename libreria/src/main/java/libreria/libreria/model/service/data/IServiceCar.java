/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.service.data;

import libreria.libreria.model.domain.data.Car;

/**
 * interface IServiceCar
 * @author Andrés David Muñoz
 */
public interface IServiceCar {
    /**
     * Guarda un objeto de la clase Car
     * @param car
     * @return boolean
     */
    public boolean save(Car car);
    
    /**
     * elimina un objeto de la clase Car
     * @param car
     * @return boolean
     */
    public boolean delete(Car car); 
    
    /**
     * Busca un objeto de la clase Car, por su atributo user_id
     * @param user_id
     * @return Car
     */
    public Car find(Long user_id); 
}
