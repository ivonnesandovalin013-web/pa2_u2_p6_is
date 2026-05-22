package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {

    public void crear(Profesor profesor);
    public Profesor seleccionar(Integer id);
    public void actualizar(Profesor profesor);
    public void eliminar(Integer id);

}
