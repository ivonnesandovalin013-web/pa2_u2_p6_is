package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Desarrollador;
import ec.edu.uce.domain.repository.DesarrolladorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DesarrolladorRepositoryImpl implements DesarrolladorRepository{

    @Inject
    private EntityManager em;


    @Override
    public void crear(Desarrollador desarrollador) {
        this.em.persist(desarrollador);
    }


    @Override
    public Desarrollador seleccionar(Integer id) {
        return this.em.find(Desarrollador.class, id);
    }

}
