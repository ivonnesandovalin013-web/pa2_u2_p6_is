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
@Table(name = "materia")
public class Materia {

    @Id
    @SequenceGenerator(name = "seq_materia_generator", sequenceName = "seq_materia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_materia_generator")
    @Column(name = "mate_id")
    private Integer id;
    @Column(name = "mate_nombre")
    private String nombre;
    @Column(name = "mate_numero_creditos")
    private Integer numeroCreditos;
    @ManyToMany(mappedBy = "materias", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Alumno> alumnos;


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
    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }
    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    

    
}
