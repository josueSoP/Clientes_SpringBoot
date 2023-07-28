package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.iPersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    private iPersonaDao personaDao;
    
    @Override // sobrescribir un método al momento que se hereda de una Interface
    //transactiona hacer un RB en caso de error o commit en exito
    @Transactional (readOnly = true) // reanOnly porque solo lee no es necesario la transaccion
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional (readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
