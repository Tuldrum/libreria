/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.domain.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * class Car - mapea un objeto de la clase Car respecto a la tabla respectiva en 
 * la base de datos 
 * @author Andrés David Muñoz
 */
@Entity
@Table(name="car")
@Data
public class Car implements Serializable{
    //atributos 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    private Long id;
    
    @NotNull
    @Column(name="user_id")
    private Long userId;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private List<car_items> items;  
    
}
