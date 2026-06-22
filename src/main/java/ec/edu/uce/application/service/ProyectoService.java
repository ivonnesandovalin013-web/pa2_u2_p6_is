package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Proyecto;
import ec.edu.uce.domain.repository.ProyectoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProyectoService {

    @Inject
    private ProyectoRepository proyectoRepository;

    @Transactional
    public void guardar(Proyecto proyecto){
        this.proyectoRepository.crear(proyecto);
    }
    @Transactional
    public Proyecto buscar(Integer id){
        return this.proyectoRepository.seleccionar(id);
    }

}
