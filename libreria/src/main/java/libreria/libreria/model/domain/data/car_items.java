/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.domain.data;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * class car_items - mapea un objeto de la clase car_items respecto a la tabla respectiva en 
 * la base de datos 
 * @author Andrés David Muñoz
 */
@Entity
@Table(name="car_items")
@Data
public class car_items implements Serializable{
    //atributos 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
       
    @NotNull
    @Column(name="cantidad") 
    private int cantidad;  
    
    @Column(name="modificado")
    private Timestamp modificado;  
    
    @ManyToOne
    @JoinColumn(name ="car_id", updatable = false)
    private Car carItem; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id", updatable = false)
    private Libro libroItem; 

}
