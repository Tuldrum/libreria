/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Módulo de seguridad 
 * @author Andrés David Muñoz 
 */
public class EncriptarPassword {
    
    /**
     * Encripta el password
     * @param password
     * @return String 
     */
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
        return encoder.encode(password); 
    }
}
