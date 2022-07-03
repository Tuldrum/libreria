/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.service.users;

import java.util.List;
import libreria.libreria.model.domain.users.Rol;

/**
 * interface IServiceRol
 * @author Andrés David Muñoz
 */
public interface IServiceRol {
    /**
     * encuentra un rol por su nombre 
     * @param name
     * @return Rol
     */
    public Rol find(String name); 
    
    /**
     * lista los roles del sistema 
     * @return List rol
     */
    public List<Rol> list();  
}
