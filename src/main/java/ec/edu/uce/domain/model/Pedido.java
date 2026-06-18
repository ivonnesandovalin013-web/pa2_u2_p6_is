package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @SequenceGenerator(name = "seq_pedido_generator", sequenceName = "seq_pedido", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pedido_generator")
    @Column(name = "pedi_id")
    private Integer id;
    @Column(name = "pedi_total")
    private Double total;
    @Column(name = "pedi_fecha")
    private LocalDate fecha;
    @ManyToOne
    private Cliente cliente;//el nombre de cliente es importante porque con el vamos a crear un vinculo con el cliente

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double valor) {
        this.total = valor;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public String toString() {
        return "Pedido [id=" + id + ", total=" + total + ", fecha=" + fecha + "]";
    }
    
    
    

}
