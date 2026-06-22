package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Desarrollador;

public interface DesarrolladorRepository {

    public void crear(Desarrollador desarrollador);
    public Desarrollador seleccionar(Integer id);

}
