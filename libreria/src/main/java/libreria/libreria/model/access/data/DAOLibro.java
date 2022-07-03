/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.access.data;

import libreria.libreria.model.domain.data.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interfaz DAOLibro - genera el repositorio para los productos del negocio
 *
 * @author Andrés David Muñoz
 */
public interface DAOLibro extends JpaRepository<Libro, Long>{
    
}
