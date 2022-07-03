/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria.model.domain.data;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * class Libro - mapea un objeto de la clase Libro respecto a la tabla respectiva en 
 * la base de datos 
 * @author Andrés David Muñoz
 */
@Entity
@Table(name = "Libro")
@Data
public class Libro implements Serializable{
    
    //atributos 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lb_id")
    private Long id;
    
    @NotEmpty
    @Column(length=50, name="lb_titulo")
    private String titulo;
    
    @NotEmpty
    @Column(length=20, name="lb_ano")
    private String anio ;
    
    @NotEmpty
    @Column(name="lb_images")
    private String images; 
    
    @NotNull
    @Column(name="lb_precio")
    private float precio; 
    
    @NotNull
    @Column(name="lb_cantidad")
    private int cantidad; 
    
    
    /*@OneToMany
    @JoinColumn(name="lb_id")
    private List<Ejemplar> ejemplares;*/
    
    /*@ManyToMany(mappedBy = "librosAutor")
    private List<Autor> authors;  */
    
    /*@ManyToMany(mappedBy = "librosCateg")
    private List<Categoria> categorias;*/
    
}
