package ec.edu.uce.domain.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "desarrollador")
public class Desarrollador {

    @Id
    @SequenceGenerator(name = "seq_desarrollador_generator", sequenceName = "seq_desarrollador", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_desarrollador_generator")
    @Column(name = "desa_id")
    private Integer id;
    @Column(name = "desa_nombre")
    private String nombre;
    @Column(name = "desa_rol")
    private String rol;
    @Column(name = "desa_fecha_ingreso")
    private LocalDate fechaIngreso;
    @ManyToMany
    @JoinTable(name = "desarrollador_proyecto", joinColumns = @JoinColumn(name = "depr_id_desarrollador"), 
    inverseJoinColumns = @JoinColumn(name = "depr_id_proyecto"))
    private List<Proyecto> proyectos;

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
