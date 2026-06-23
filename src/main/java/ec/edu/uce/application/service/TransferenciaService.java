package ec.edu.uce.application.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TransferenciaService {

    @Inject
    private TransferenciaRepository transferenciaRepository;

    @Inject
    private CuentaBancariaRepository cuentaBancariaRepository;

    @Transactional
    public void registrarTransferencia(Integer idOrigen, Integer idDestino, BigDecimal monto){
        CuentaBancaria origen = this.cuentaBancariaRepository.seleccionar(idOrigen);
        CuentaBancaria destino = this.cuentaBancariaRepository.seleccionar(idDestino);
 
        if (origen == null || destino == null) {
            throw new RuntimeException("Alerta: Una de las cuentas no existe.");
        }
        if (origen.getSaldo().compareTo(monto) < 0) {
            throw new RuntimeException("Alerta: Saldo insuficiente en la cuenta de origen.");
        }

        origen.setSaldo(origen.getSaldo().subtract(monto));
        destino.setSaldo(destino.getSaldo().add(monto));

        Transferencia comprobante = new Transferencia();
        comprobante.setCuentaOrigen(origen);
        comprobante.setCuentaDestino(destino);
        comprobante.setMonto(monto);
        comprobante.setFechaTransferencia(LocalDate.now());

        this.cuentaBancariaRepository.actualizar(origen);
        this.cuentaBancariaRepository.actualizar(destino);
        this.transferenciaRepository.crear(comprobante);
    }

}
