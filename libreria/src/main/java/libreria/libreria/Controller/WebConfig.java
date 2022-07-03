package libreria.libreria.Controller;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver; 


/**
 * Configuraciones de la web 
 * @author Andrés David Muñoz 
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver(); 
        slr.setDefaultLocale(new Locale("es"));
        return slr;    
    }
    
    @Bean 
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();  
        lci.setParamName("lang");
        return lci; 
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor()); 
    }
    
    /**
     * vistas relacionadas a las urls 
     * @param registry 
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //registry.addViewController("/").setViewName("index");
        registry.addViewController("/login");
        registry.addViewController("/errores/403").setViewName("/errores/403");
    }
    
    
    
}
