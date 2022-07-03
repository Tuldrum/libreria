/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.Controller;

import javax.validation.Valid;
import libreria.libreria.model.domain.data.Libro;
import libreria.libreria.model.service.data.IServiceCarItem;
import libreria.libreria.model.service.data.IServiceLibro;
import libreria.libreria.model.utils.UtilitiesGestionProductos;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * class GestionProductosController mapea la gestion de productos 
 * @author Andrés David Muñoz
 */
@Controller
@RequestMapping("/gestion")
public class GestionProductosController {
    
    private String state;  
    
    //atributos por inyección de dependencias 
    @Autowired 
    private IServiceLibro libroService;  
    
    @Autowired
    private IServiceCarItem itemservice;  
    
    //métodos 
    /**
     * Agrega un nuevo libro 
     * @param libro libro mapeado desde la vista
     * @return 'modificar' view
     */
    @GetMapping("/agregar")
    public String agregar(Libro libro){
        state = "added";  
        return "modificar";  
    }
    
    /**
     * Permite editar la información de un libro 
     * @param libro mapeado desde la vista 
     * @param model atributos para la vista 
     * @return 'modificar' view 
     */
    @GetMapping("/editar/{id}")
    public String editar(Libro libro, Model model){
        state="edited"; 
        libro = libroService.get(libro); 
        libro.setImages(
            UtilitiesGestionProductos.shareDrive(libro.getImages())
        );
        model.addAttribute("libro", libro);
        return "modificar";  
    }
    
    /**
     * Guarda un libro 
     * @param libro mapeado desde la vista 
     * @param errores errores sobre campos vacíos o nulos 
     * @return "redirect:/?state" si se guarda con éxito, si no, 'modificar' view 
     */
    @PostMapping("/guardar")
    public String guardar(@Valid Libro libro, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        String newURLImages = UtilitiesGestionProductos.extraerIDImgs(libro.getImages());  
        libro.setImages(newURLImages); 
        libroService.save(libro);
        return "redirect:/?".concat(state); 
    }
    
    /**
     * Elimina un libro
     * @param libro libro mapeado desde la vista 
     * @return "redirect:/" 
     */
    @GetMapping("/eliminar")
    public String eliminar(Libro libro){
        
        itemservice.deleteByLibro(libro);
        
        libroService.delete(libro);
        
        return "redirect:/"; 
    }
        
}
