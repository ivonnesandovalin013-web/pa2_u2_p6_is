package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Automovil;
import ec.edu.uce.domain.repository.AutomovilRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AutomovilService {

    @Inject 
    private AutomovilRepository automovilRepository;

    public void guardar(Automovil automovil){
        this.automovilRepository.crear(automovil);
    }

}
