package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Automovil;
import ec.edu.uce.domain.model.Motor;
import ec.edu.uce.domain.repository.MotorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MotorServices {

    @Inject
    private MotorRepository motorRepository;

    @Inject
    private AutomovilService automovilService;

    @Transactional
    public void guardar(Motor motor){
        //Automovil a = new Automovil();
        this.motorRepository.crear(motor);
    }

}
