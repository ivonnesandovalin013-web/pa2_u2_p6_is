package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovil")
public class Automovil {

    @Id
    @SequenceGenerator(name = "seq_automovil_generator", sequenceName = "seq_automovil", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_automovil_generator")
    @Column(name = "auto_id")
    private Integer id;
    @Column(name = "auto_chasis")
    private Integer chasis;
    @Column(name = "auto_modelo")
    private String modelo;
    @Column(name = "auto_marca")
    private String marca;
    @Column(name = "auto_color")
    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChasis() {
        return chasis;
    }

    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Automovil [id=" + id + ", chasis=" + chasis + ", modelo=" + modelo + ", marca=" + marca + ", color="
                + color + "]";
    }

    

}
