package ec.edu.uce.infrastructure.repository;

import com.arjuna.ats.arjuna.common.recoveryPropertyManager;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaRepositoryImpl implements CuentaBancariaRepository{

    @Inject
    private EntityManager em;

    @Override
    public void crear(CuentaBancaria cuenta) {
        this.em.persist(cuenta);
    }

    @Override
    public CuentaBancaria seleccionar(Integer id) {
        return this.em.find(CuentaBancaria.class, id);
    }

    @Override
    public void actualizar(CuentaBancaria cuenta) {
        this.em.merge(cuenta);
    }

}
