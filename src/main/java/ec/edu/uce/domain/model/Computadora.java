package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "computadora")
public class Computadora {
    @Id
    @SequenceGenerator(name = "seq_computadora_generator", sequenceName = "seq_computadora", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_computadora_generator")
    @Column(name = "comp_id")
    private Integer id;
    @Column(name = "comp_marca")
    private String marca;
    @Column(name = "comp_modelo")
    private String modelo;
    @OneToMany(mappedBy = "computadora",cascade = CascadeType.ALL)
    private List<Componente> componentes;
    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public List<Componente> getComponentes() {
        return componentes;
    }
    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
    @Override
    public String toString() {
        return "Computadora [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", componentes=" + componentes
                + "]";
    }
    
    
    
    
    
}
