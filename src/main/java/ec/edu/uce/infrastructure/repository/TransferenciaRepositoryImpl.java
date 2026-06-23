package ec.edu.uce.infrastructure.repository;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class TransferenciaRepositoryImpl implements TransferenciaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Transferencia transferencia) {
        this.em.persist(transferencia);
    }
    


}
