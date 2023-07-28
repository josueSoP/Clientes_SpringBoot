package mx.com.gm.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //manejo de log
public class ControladorInicio {
    
    @Autowired //inyectamos interface DAO
    private PersonaService personaService;
    
    @GetMapping("/")
    public String incio(Model model, @AuthenticationPrincipal User user){
       var personas = personaService.listarPersonas(); //regresa la lista de objetos persona
       log.info("ejecutando el controlador REST en log");
       log.info("usuario que hizo login: "+user);
       model.addAttribute("personas",personas);
       return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){//objeto de tipo persona ya no usamos new
       return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){ //Valid para validacion
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        //este metodo encuentra un obj tipo persona y lo asignamos a la misma variable:
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona); //compartimos el objeto recuperado
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}


