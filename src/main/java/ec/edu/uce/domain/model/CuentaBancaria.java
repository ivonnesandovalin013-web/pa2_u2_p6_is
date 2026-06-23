package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

    @Id
    @SequenceGenerator(name = "seq_cuenta_bancaria_generator", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_bancaria_generator")
    @Column(name = "cuen_id")
    private Integer id;
    @Column(name = "cuen_numero_cuenta")
    private String numeroCuenta;
    @Column(name = "cuen_saldo")
    private BigDecimal saldo;
    @OneToMany(mappedBy = "cuentaOrigen", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transferencia> transferenciasEnviadas = new ArrayList<>();
    @OneToMany(mappedBy = "cuentaDestino", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transferencia> transferenciasRecibidas = new ArrayList<>();
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    public List<Transferencia> getTransferenciasEnviadas() {
        return transferenciasEnviadas;
    }
    public void setTransferenciasEnviadas(List<Transferencia> transferenciasEnviadas) {
        this.transferenciasEnviadas = transferenciasEnviadas;
    }
    public List<Transferencia> getTransferenciasRecibidas() {
        return transferenciasRecibidas;
    }
    public void setTransferenciasRecibidas(List<Transferencia> transferenciasRecibidas) {
        this.transferenciasRecibidas = transferenciasRecibidas;
    }
    @Override
    public String toString() {
        return "CuentaBancaria [id=" + id + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
    }


    
}
