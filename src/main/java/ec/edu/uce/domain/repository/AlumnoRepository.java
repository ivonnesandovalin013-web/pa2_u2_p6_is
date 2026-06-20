package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Alumno;

public interface AlumnoRepository {

    public void crear(Alumno alumno);

    public Alumno seleccionar(Integer id);

}
