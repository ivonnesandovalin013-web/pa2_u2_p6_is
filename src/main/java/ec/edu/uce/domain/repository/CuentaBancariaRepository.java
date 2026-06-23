package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.CuentaBancaria;

public interface CuentaBancariaRepository {

    public void crear(CuentaBancaria cuenta);
    public CuentaBancaria seleccionar(Integer id);
    public void actualizar(CuentaBancaria cuenta);
}
