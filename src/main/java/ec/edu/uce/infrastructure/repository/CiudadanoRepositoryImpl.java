package ec.edu.uce.infrastructure.repository;


import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.repository.CiudadanoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CiudadanoRepositoryImpl implements CiudadanoRepository {
    @Inject
    private EntityManager em;

    @Override
    public void crear(Ciudadano ciudadano) {
        this.em.persist(ciudadano);
    }



}
