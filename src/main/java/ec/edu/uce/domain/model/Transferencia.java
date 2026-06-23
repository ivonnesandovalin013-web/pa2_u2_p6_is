package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaferencia")
public class Transferencia {

    @Id
    @SequenceGenerator(name = "seq_transferencia_generator", sequenceName = "seq_transferencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia_generator")
    @Column(name = "tran_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "tran_cuenta_origen_id")
    private CuentaBancaria cuentaOrigen;
    @ManyToOne
    @JoinColumn(name = "tran_cuenta_destino_id")
    private CuentaBancaria cuentaDestino;
    @Column(name = "tran_monto")
    private BigDecimal monto;
    @Column(name = "tran_fecha_transferencia")
    private LocalDate fechaTransferencia;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }
    public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }
    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }
    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public LocalDate getFechaTransferencia() {
        return fechaTransferencia;
    }
    public void setFechaTransferencia(LocalDate fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    

}
