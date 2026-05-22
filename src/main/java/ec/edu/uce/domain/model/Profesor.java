package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    @SequenceGenerator(name = "seq_profesor_generador", sequenceName = "seq_profesor", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profesor_generador")
    @Column(name = "prof_id")
    private Integer id;
    @Column(name = "prof_nombre")
    private String nombre;
    @Column(name = "prof_apellido")
    private String apellido;
    @Column(name = "prof_asignatura")
    private String asignatura;


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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    

}
