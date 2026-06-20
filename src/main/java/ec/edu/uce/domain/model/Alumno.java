package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @SequenceGenerator(name = "seq_alumno_generator", sequenceName = "seq_alumno", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alumno_generator")
    @Column(name = "alum_id")
    private Integer id;
    @Column(name = "alum_nombre")
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "alumno_materia", joinColumns = @JoinColumn(name = "alma_id_alumno"), inverseJoinColumns = @JoinColumn(name="alma_id_materia"))
    private List<Materia> materias;

    //SET Y GET
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
    public List<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
    
    
}
