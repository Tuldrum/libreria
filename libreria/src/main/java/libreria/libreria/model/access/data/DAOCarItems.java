/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.access.data;

import libreria.libreria.model.domain.data.Car;
import libreria.libreria.model.domain.data.Libro;
import libreria.libreria.model.domain.data.car_items;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interfaz DAOCarItems - genera el repositorio para los items del
 * carrito de compras
 *
 * @author Andrés David Muñoz
 */
public interface DAOCarItems extends JpaRepository<car_items, Long> {
    /**
     * busca un item mapeado por un objeto Car y un objeto Libro 
     * @param carItem objeto de la clase Car
     * @param libroItem objeto de la clase Libro
     * @return car_items
     */
    public car_items findByCarItemAndLibroItem(Car carItem, Libro libroItem); 
    
    /**
     * Elimina items relacionados a un objeto de la clase Libro
     * @param libroItem 
     */
    public void deleteByLibroItem(Libro libroItem); 
}
