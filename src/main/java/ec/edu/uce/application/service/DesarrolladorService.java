package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Desarrollador;
import ec.edu.uce.domain.repository.DesarrolladorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DesarrolladorService {

    @Inject
    private DesarrolladorRepository desarrolladorRepository;

    @Transactional
    public void guardar(Desarrollador desarrollador){
        this.desarrolladorRepository.crear(desarrollador);
    }

    @Transactional
    public Desarrollador buscar(Integer id){
        return this.desarrolladorRepository.seleccionar(id);
    }
    

}
