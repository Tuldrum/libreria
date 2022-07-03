/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.access.data;

import libreria.libreria.model.domain.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz DAOCar - genera el repositorio para el carrito de compras 
 *
 * @author Andrés David Muñoz
 */
public interface DAOCar extends JpaRepository<Car, Long>{
    /**
     * Busca un objeto Car por su atributo userId 
     * @param userId identificador del usuario en sesión
     * @return Car
     */
    public Car findByUserId(Long userId);
}
