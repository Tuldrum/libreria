/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.service.data;

import libreria.libreria.model.domain.data.Libro;
import libreria.libreria.model.domain.data.car_items;

/**
 * interface IServiceCarItem - 
 * define los servicios para los items del carrito de compra
 * @author ASUS
 */
public interface IServiceCarItem {
    
    /**
     * guarda un item 
     * @param item 
     */
    public void save(car_items item);  
    
    /**
     * elimina un item
     * @param item 
     */
    public void delete(car_items item); 
    
    /**
     * busca un item 
     * @param item
     * @return 
     */
    public car_items get(car_items item);
    
    /**
     * busca un item por id_car, id_libro 
     * @param car
     * @param libro
     * @return car_items
     */
    public car_items findByCarItemANDLibroItem(Long car,Long libro);  
    
    /**
     * Elimina los items asociados a un libro 
     * @param libro
     * @return 
     */
    public boolean deleteByLibro(Libro libro);  
}
