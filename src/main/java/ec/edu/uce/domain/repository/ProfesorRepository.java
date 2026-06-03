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
    public List<Profesor> seleccionarPorGeneroCriterial(String genero);
    public List<Profesor> seleccionarPorNombreEmpieceCon(String letra);
    public Long contarProfesores();
    public List<Profesor> seleccionarDinamicoCriterial(String cedula, String nombre, String genero);


}
