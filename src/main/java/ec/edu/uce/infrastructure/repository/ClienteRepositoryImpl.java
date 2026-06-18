package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteRepositoryImpl implements ClienteRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(Cliente cliente) {
        this.em.persist(cliente);
    }

}
