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
 * Archivo de configuracion de conexión a la base de datos de usuario 
 *
 * @author Andrés David Muñoz
 * andresdmunoz@unicauca.edu.co
 */
@Configuration
@Primary
@EnableJpaRepositories(
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager",
        basePackages = {"libreria.libreria.model.access.users"}
)
public class ConectionDBUsers {

    @Autowired
    private Environment env;

    /**
     * Genera una configuración de conexión a una base de datos
     *
     * @return Datasource
     */
    @Bean(name = "userDataSource")
    public DataSource userDataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl(env.getProperty("users.datasource.url"));
        datasource.setUsername(env.getProperty("users.datasource.username"));
        datasource.setPassword(env.getProperty("users.datasource.password"));
        datasource.setDriverClassName(env.getProperty("users.datasource.driver-class-name"));
        return datasource;
    }

    /**
     * Contenedor de tipo Bean, que mapea la base de datos
     *
     * @return LocalContainerEntityManagerFactoryBean
     */
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDataSource());
        em.setPackagesToScan("libreria.libreria.model.domain.users");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("users.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("users.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("users.jpa.database-plattform"));
        return em;
    }

    /**
     * Lanza los servicios generados por LocalContainerEntityManagerFactoryBean
     *
     * @return PlatformTransactionManager
     */
    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
