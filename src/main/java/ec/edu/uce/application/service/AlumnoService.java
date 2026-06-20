package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AlumnoService {

    @Inject
    private AlumnoRepository alumnoRepository;

    @Transactional
    public void guardar(Alumno alumno){
        this.alumnoRepository.crear(alumno);
    }

    @Transactional
    public Alumno buscar(Integer id){
        return this.alumnoRepository.seleccionar(id);
    }

}
