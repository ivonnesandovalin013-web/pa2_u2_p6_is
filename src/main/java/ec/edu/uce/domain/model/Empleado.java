package ec.edu.uce.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @SequenceGenerator(name = "seq_empleado_generator", sequenceName = "seq_empleado", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empleado_generator")
    @Column(name = "empl_id")
    private Integer id;
    @Column(name = "empl_salario")
    private Double salario;
    @Column(name = "empl_fecha_ingreso")
    private LocalDateTime fechaIngreso;
    @OneToOne //sobre este atributo menciono que tiene una relacion one to one
    @JoinColumn(name = "empl_ciudadano") // nombre de la columna en la tabla de empleados que referencia a la tabla de ciudadanos
    private Ciudadano ciudadano;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
    

}
