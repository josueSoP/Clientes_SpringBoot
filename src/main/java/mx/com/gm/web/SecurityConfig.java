//package mx.com.gm.web;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration//clase de configuracion de spring
//@EnableWebSecurity //anotacion para seguridad Web
//public class SecurityConfig extends WebSecurityConfigurerAdapter{ //extiende de la clase WebSCA
//    
//    @override
//    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                    .password("{nop}123")
//                    .roles("AMIN", "USER")
//                .and()
//                .withUser("admin")
//                    .password("{nop}123")
//                    .roles("USER")
//                ;
//    }
//    
//    //restringir (AUTORIZACION)
//    @Override
//    protected void configure (HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/editar/**","/agregar/**","/elimina") //restringe rutas y subrutas (**)
//                    .hasRole("AMIN")
//                .antMatchers("/")
//                    .hasRole("USER","ADMIN")
//                .and()
//                    .formLogin()
//                    .loginPage("/login") //definimos la pagina de loggin y que no muestre la pagina pordefault
//                .and()
//                    .exceptionHandling(.accessDeniedPage("/errores/403")) //personalizamos pagina de error en caso de acceso denegado
//                ;
//    }
//}