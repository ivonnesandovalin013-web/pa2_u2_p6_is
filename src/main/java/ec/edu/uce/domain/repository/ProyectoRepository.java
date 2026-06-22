package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Proyecto;

public interface ProyectoRepository {
    public void crear(Proyecto proyecto);
    public Proyecto seleccionar(Integer id);

}
