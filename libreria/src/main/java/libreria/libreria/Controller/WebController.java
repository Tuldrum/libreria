/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.Controller;

import libreria.libreria.model.service.data.IServiceLibro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal 
 * @author ASUS
 */
@Controller 
@Slf4j
public class WebController {
   
    // atributos 
   @Autowired
   private IServiceLibro service;  
   
   /**
    * deslpiega la vista de login 
    * @param model
    * @return 
    */
   @GetMapping("/login")
   public String iniciarSesion(Model model) {
       return "login";
   }
   
   /**
    * Despliega la página principal 
    * @param model atributos de la vista 
    * @return "index" view 
    */
   @GetMapping("/")
   public String paginaPrincipal(Model model){
       model.addAttribute("libros", service.list());
       return "index"; 
   }
   
}
