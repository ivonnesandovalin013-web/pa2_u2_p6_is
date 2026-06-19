package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Computadora;
import ec.edu.uce.domain.repository.ComputadoraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ComputadoraRepositoryImpl implements ComputadoraRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Computadora computadora) {
        this.em.persist(computadora);
    }

}
