package ec.edu.uce.domain.model;

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
@Table(name = "motor")
public class Motor {

    @Id
    @SequenceGenerator(name = "seq_motot_generator", sequenceName = "seq_motor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_motor_generator")
    @Column(name = "motor_id")
    private Integer id;
    @Column(name = "motor_numero_serie")
    private String numeroSerie;
    @Column(name = "motor_cilindraje")
    private String cilindraje;
    @OneToOne
    @JoinColumn(name = "motor_auto_id")
    private Automovil automovil;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getCilindraje() {
        return cilindraje;
    }
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }
    public Automovil getAutomovil() {
        return automovil;
    }
    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    

}
