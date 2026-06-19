package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "componente")
public class Componente {

    @Id
    @SequenceGenerator(name = "seq__componente_generator", sequenceName = "seq_componente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_componente_generator")
    @Column(name = "compo_id")
    private Integer id;
    @Column(name = "compo_nombre")
    private String nombre;
    @Column(name = "compo_tipo")
    private String tipo;
    @ManyToOne
    private Computadora computadora;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Computadora getComputadora() {
        return computadora;
    }
    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }
    @Override
    public String toString() {
        return "Componente [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
    }
    


    

}
