package ec.edu.uce.domain.repository;

import java.util.List;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {

    public void crear(Estudiante estudiante);
    public Estudiante seleccionar(Integer id);
    public void actualizar(Estudiante estudiante);
    public void eliminar(Integer id);
    public List<Estudiante> seleccionarTodos();
    public List<Estudiante> seleccionarPorNombre(String nombre);
    public Estudiante seleccionarPorCedula(String cedula);
    

}
