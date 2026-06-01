package ec.edu.uce.domain.repository;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {

    public void crear(Profesor profesor);
    public Profesor seleccionar(Integer id);
    public void actualizar(Profesor profesor);
    public void eliminar(Integer id);
    public List<Profesor> seleccionarPorAsignatura(String asignatura);
    public Long contarPorGradoAcademico(String gradoAcademico);
    public List<Profesor> seleccionarSueldoMayorA(Integer sueldo);
    public List<Profesor> seleccionarPorAsignaturaNamed(String asignatura);
    public Long contarPorGradoAcademicoNamed(String gradoAcademico);
    public List<Profesor> seleccionarSueldoMayorANamed(Integer sueldo);
    public Profesor seleccionarPorCedulaNativo(String cedula);
    public List<Profesor> seleccionarPorNombreNativo(String nombreTexto);
    public List<Profesor> seleccionarPorGeneroNativo(String genero);

}
