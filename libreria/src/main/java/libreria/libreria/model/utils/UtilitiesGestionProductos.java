/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.utils;

/**
 * Módulo de conversión de formato url
 *
 * @author Andrés David Muñoz
 */
public class UtilitiesGestionProductos {
    
    /**
     * Configura el path de drive que se almacenará en la base de datos  
     * @param cadena
     * @return 
     */
    public static String extraerIDImgs(String cadena) {
        String cadena2 = (cadena.split("file/d/")[1]).split("/view")[0];
        return asignarEnlaceDrive(cadena2);
    }
    
    /**
     * Establece el enlace drive, que se alamacenará en la base de datos 
     * @param cadena
     * @return String 
     */
    public static String asignarEnlaceDrive(String cadena) {
        String path = "http://drive.google.com/uc?export=view&id=";
        return path + cadena;
    }

    /**
     * Reconstruye el path almacenado en la base de datos, al formato de enlace de compartido 
     * estándar 
     * @param cadena
     * @return 
     */
    public static String shareDrive(String cadena) {

        String cadena2 = cadena.split("view&id=")[1];
        return "https://drive.google.com/file/d/"
                .concat(cadena2)
                .concat("/view?usp=sharing");
    }
}
