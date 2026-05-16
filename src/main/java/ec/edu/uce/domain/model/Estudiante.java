package ec.edu.uce.domain.model;
//Todos los modelos que se mapean a la base de datos van en este paquete, es decir, las entidades del dominio

import java.time.LocalDate;

import io.quarkus.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // Esta anotación indica que esta clase es una entidad de JPA, lo que significa
        // que se mapeará a una tabla en la base de datos. JPA (Java Persistence API) es
        // una especificación de Java para la gestión de datos relacionales en
        // aplicaciones Java. Al marcar esta clase con @Entity, le estamos diciendo a
        // JPA que esta clase representa una tabla en la base de datos y que sus
        // instancias serán filas en esa tabla. Además, JPA proporcionará
        // funcionalidades para realizar operaciones CRUD (Crear, Leer, Actualizar,
        // Eliminar) en esta entidad.
@Table(name = "estudiante") // a que tabla se va a mapear esta entidad, si no se especifica el nombre de la
                            // tabla, JPA usará el nombre de la clase como nombre de la tabla por defecto.
                            // En este caso, la tabla se llamará "estudiante". Si quisieras especificar un
                            // nombre diferente para la tabla, podrías hacerlo así: @Table(name =
                            // "nombre_de_la_tabla").
public class Estudiante {
    @Id
    @SequenceGenerator(name = "seq_estudiante_generador", sequenceName = "seq_estudiante", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estudiante_generador")
    @Column(name = "estu_id")
    private Integer id;
    @Column(name = "estu_nombre")
    private String nombre;
    @Column(name = "estu_apellido")
    private String apellido;
    @Column(name = "estu_fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "estu_genero")
    private String genero;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

}
