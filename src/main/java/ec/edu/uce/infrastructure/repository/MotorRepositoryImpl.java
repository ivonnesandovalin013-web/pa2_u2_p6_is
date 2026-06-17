package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Motor;
import ec.edu.uce.domain.repository.MotorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MotorRepositoryImpl implements MotorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Motor motor) {
        this.em.persist(motor);
        
    }

   

   

}
