package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariService {

    @Inject
    private CuentaBancariaRepository cuentaRepository;

    public void guardar(CuentaBancaria cuenta){
        this.cuentaRepository.crear(cuenta);
    }

    public CuentaBancaria buscar(Integer id){
        return this.cuentaRepository.seleccionar(id);
    }

    public void actualizar(CuentaBancaria cuenta){
        this.cuentaRepository.actualizar(cuenta);
    }

}
