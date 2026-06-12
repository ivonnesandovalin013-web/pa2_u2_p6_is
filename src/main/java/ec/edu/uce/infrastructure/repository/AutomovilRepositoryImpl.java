package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Automovil;
import ec.edu.uce.domain.repository.AutomovilRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AutomovilRepositoryImpl implements AutomovilRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Automovil automovil) {
       this.em.persist(automovil);
    }



}
