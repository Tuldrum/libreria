/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.Controller;

import java.util.List;
import libreria.libreria.model.domain.data.Car;
import libreria.libreria.model.domain.data.Libro;
import libreria.libreria.model.domain.data.car_items;
import libreria.libreria.model.domain.users.Usuario;
import libreria.libreria.model.service.data.IServiceCar;
import libreria.libreria.model.service.data.IServiceCarItem;
import libreria.libreria.model.service.data.IServiceLibro;
import libreria.libreria.model.service.users.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador del path /carrito 
 * @author ASUS
 */
@Controller
@RequestMapping("/carrito")
public class GestionCarritoCompras {
    
    @Autowired 
    private UsuarioService userservice;  
    
    @Autowired
    private IServiceCar carservice;  
    
    @Autowired 
    private IServiceCarItem itemservice;  
    
    @Autowired 
    private IServiceLibro libroservice;
    
    /**
     * Despliega el contenido del carrito de compras 
     * @param model atributos relacionados a la vista a desplegar
     * @param principal usuario en sesión 
     * @return vista 'item_view'
     */
    @GetMapping("/")
    public String mostrarItems(Model model, @AuthenticationPrincipal User principal){
        Usuario usr = userservice.buscarUsuario(principal.getUsername());
        Car car = carservice.find(usr.getId_usuario());
        model.addAttribute("v_items", car.getItems());  
        model.addAttribute("v_total", getTotal(car.getItems()));
        model.addAttribute("v_user", usr.getNombre()); 
        return "item_view"; 
    }
    
    /**
     * Agrega un nuevo item al carrito de compras, despliega la vista para 
     * agregar un nuevo item. 
     * @param libro libro mapeado desde la vista 
     * @param model atributos de para la vista 
     * @param principal usuario en sesión 
     * @return 'item'
     */
    @GetMapping("/agregar/{id}")
    public String agregar(Libro libro, Model model, @AuthenticationPrincipal User principal){
        libro = libroservice.get(libro); 
        Usuario usr = userservice.buscarUsuario(principal.getUsername());
        
        Car car = carservice.find(usr.getId_usuario());
        car.setItems(null);
        
        car_items item = itemservice.findByCarItemANDLibroItem(car.getId(), libro.getId());  
        
        if(item == null){
            item = new car_items();  
            item.setCantidad(0);
            item.setLibroItem(libro);
        }
        item.setCarItem(car);
        
        model.addAttribute("v_item", item);
        return "item";  
    }   
    
    /**
     * Elimina un item del carrito de compras 
     * @param item
     * @return 'redirect:/carrito'
     */
    @GetMapping("/eliminar")
    public String eliminar(car_items item){
        itemservice.delete(item);
        return "redirect:/carrito/"; 
    }
    
    /**
     * Edita un item del carrito de compras
     * @param item item a editar
     * @param model variables para la vista 
     * @return 'item' 
     */
    @GetMapping("/editar/{id}")
    public String editar(car_items item, Model model){
        item = itemservice.get(item); 
        
        Car car = item.getCarItem();  
        car.setItems(null);
        item.setCarItem(car);
        
        model.addAttribute("v_item", item);
        return "item";  
    }
    
    /**
     * Guarda un item y despliega la vista de carrito 
     * @param item item a guardar en el carrito 
     * @param errores errores, como campos vacíos o nulos 
     * @return 'redirect:/carrito/'
     */
    @PostMapping("/guardar")
    public String guardar(car_items item, Errors errores){
        if(errores.hasErrors()){
            return "item";
        }
        itemservice.save(item);
        return "redirect:/carrito/"; 
    }
    
    private float getTotal(List<car_items> items){
        float total = (float) 0.0;  
        if(!items.isEmpty()){
            for(car_items item: items){
                float precio  = item.getLibroItem().getPrecio();
                int cantidad = item.getCantidad();  
                total += precio*cantidad; 
            }
        }
        return total; 
    }
    
}
