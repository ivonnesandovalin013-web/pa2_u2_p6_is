package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MateriaService {
    @Inject
    private MateriaRepository materiaRepository;

    @Transactional
    public void guardar(Materia materia){
        this.materiaRepository.crear(materia);
    }

    @Transactional
    public Materia buscar(Integer id){
        return this.materiaRepository.buscar(id);
    }

}
