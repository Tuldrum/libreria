/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package libreria.libreria.model.access.users;

import libreria.libreria.model.domain.users.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio DAORol 
 * permite gestionar los roles del sistema 
 * @author Andrés David Muñoz
 */
public interface DAORol extends JpaRepository<Rol, Long>{
    /**
     * Encuentra un rol por su nombre 
     * @param nombre
     * @return Rol
     */
    Rol findByNombre(String nombre);
}
