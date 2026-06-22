package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @SequenceGenerator(name = "seq_proyecto_generator", sequenceName = "seq_proyecto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proyecto_generator")
    @Column(name = "proy_id")
    private Integer id;
    @Column(name = "proy_nombre")
    private String nombre;
    @ManyToMany(mappedBy = "proyectos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Desarrollador> desarrolladors;
    
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
    public List<Desarrollador> getDesarrolladors() {
        return desarrolladors;
    }
    public void setDesarrolladors(List<Desarrollador> desarrolladors) {
        this.desarrolladors = desarrolladors;
    }

    
    
}
