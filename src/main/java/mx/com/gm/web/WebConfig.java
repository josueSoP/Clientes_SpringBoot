package mx.com.gm.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver; //clase internacinalitacion


@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){ //interface localeResolver
        var slr = new SessionLocaleResolver(); //clase de api spring implementacion Session
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    
    //interceptor para cambiar lenguaje de manera dinamica
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    //Registramos el intercepto anterior
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    //definimos Paths que utilizaremos sin nececidad de entrar en un controlador (redirigimos a la vista)
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("/index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403"); //mapeo de pagina de error
    }
}
