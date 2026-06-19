package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Computadora;
import ec.edu.uce.domain.repository.ComputadoraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ComputadoraService {

    @Inject
    private ComputadoraRepository computadoraRepository;
    @Transactional
    public void guardar(Computadora computadora){
        this.computadoraRepository.crear(computadora);
    }



}
