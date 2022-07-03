/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.service.data;

import java.util.List;
import libreria.libreria.model.domain.data.Libro;

/**
 * Interface service libro 
 * @author Andrés David Muñoz 
 */
public interface IServiceLibro {
    /**
     * busca un libro mapeando un objeto de la clase Libro 
     * @param lb
     * @return Libro
     */
    public Libro get(Libro lb);  
    
    /**
     * Elimina un libro por mapeo 
     * @param lb 
     */
    public void delete(Libro lb);  
    
    /**
     * Guarda un libro en el sistema 
     * @param lb 
     */
    public void save(Libro lb);  
    
    /**
     * Lista los libros disponibles 
     * @return 
     */
    public List<Libro> list(); 
}
