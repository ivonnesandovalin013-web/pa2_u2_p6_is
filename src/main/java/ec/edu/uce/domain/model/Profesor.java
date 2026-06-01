package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.inject.Named;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.seleccionarPorAsignatura", query = "SELECT p FROM Profesor p WHERE p.asignatura LIKE :asignatura"),
    @NamedQuery(name = "Profesor.contarPorGradoAcademico", query = "SELECT COUNT(p) FROM Profesor p WHERE p.gradoAcademico LIKE :gradoAcademico"),
    @NamedQuery(name = "Profesor.seleccionarPorSueldoMayorA", query = "SELECT p FROM Profesor p WHERE p.sueldo > :sueldo")
})
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
    @Column(name = "prof_grado_académico")
    private String gradoAcademico;
    @Column(name = "prof_sueldo")
    private Integer sueldo;
    @Column(name = "prof_fecha_ingreso")
    private LocalDate fechaIngreso;
    @Column(name = "prof_cedula")
    private String cedula;
    @Column(name = "prof_genero")
    private String genero;

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
    public String getGradoAcademico() {
        return gradoAcademico;
    }
    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    public Integer getSueldo() {
        return sueldo;
    }
    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", asignatura=" + asignatura
                + ", gradoAcademico=" + gradoAcademico + ", sueldo=" + sueldo + ", fechaIngreso=" + fechaIngreso
                + ", cedula=" + cedula + ", genero=" + genero + "]";
    }
    
    
    
    

}
