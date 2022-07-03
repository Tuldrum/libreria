/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreria;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Archivo de configuracion de conexión a la base de datos de datos 
 *
 * @author Andrés David Muñoz
 * andresdmunoz@unicauca.edu.co
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "DataEntityManagerFactory", 
        transactionManagerRef = "DataTransactionManager", 
        basePackages = {"libreria.libreria.model.access.data"}
) 
public class MySQLDataConfig {
    @Autowired
    private Environment env;  
    
    /**
     * Establece la configuración de la base de datos principal 
     * @return 
     */
    @Primary
    @Bean(name = "DataDataSource")
    public DataSource userDataSource(){
       DriverManagerDataSource datasource = new DriverManagerDataSource();  
       datasource.setUrl(env.getProperty("data.datasource.url"));
       datasource.setUsername(env.getProperty("data.datasource.username"));
       datasource.setPassword(env.getProperty("data.datasource.password")); 
       datasource.setDriverClassName(env.getProperty("data.datasource.driver-class-name"));
       return datasource;  
    }
    
    /**
     * Configuraciones adicionales para el entityManagerFactory
     * @return 
     */
    @Primary
    @Bean(name = "DataEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em  = new LocalContainerEntityManagerFactoryBean();  
        em.setDataSource(userDataSource());
        em.setPackagesToScan("libreria.libreria.model.domain.data");
        
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();  
        em.setJpaVendorAdapter(vendorAdapter);
        
        Map<String, Object> properties =  new HashMap<>();  
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("data.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("data.jpa.show-sql"));
    	properties.put("hibernate.dialect", env.getProperty("data.jpa.database-plattform"));
        return em; 
    }
    
    /**
     * Crea un transactionManager para gestionar las transferencias e interacciones con la base de 
     * datos 
     * @return 
     */
    @Primary
    @Bean(name = "DataTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());	
        return transactionManager;
    }
    
}
