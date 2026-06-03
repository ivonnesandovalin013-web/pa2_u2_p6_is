package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesorService {
    @Inject
    private ProfesorRepository profesorRepository;

    public void guardar(Profesor profesor){
        this.profesorRepository.crear(profesor);
    }

    public Profesor buscar(Integer id){
        return this.profesorRepository.seleccionar(id);
    }

    public void actualizar(Profesor profesor){
        this.profesorRepository.actualizar(profesor);
    }

    public void eliminar(Integer id){
        this.profesorRepository.eliminar(id);
    }

    public List<Profesor> buscarPorAsignatura(String asignatura){
        return this.profesorRepository.seleccionarPorAsignatura(asignatura);
    }

    public Long contarPorGradoAcademico(String gradoAcademico){
        return this.profesorRepository.contarPorGradoAcademico(gradoAcademico);
    }

    public List<Profesor> buscarSueldosMayoresA(Integer sueldo){
        return this.profesorRepository.seleccionarSueldoMayorA(sueldo);
    }

    public List<Profesor> buscarPorAsignaturaNamed(String asignatura){
        return this.profesorRepository.seleccionarPorAsignaturaNamed(asignatura);
    }

    public Long contarPorGradoAcademicoNamed(String gradoAcademico){
        return this.profesorRepository.contarPorGradoAcademicoNamed(gradoAcademico);
    }

    public List<Profesor> buscarSueldosMayoresANamed(Integer sueldo){
        return this.profesorRepository.seleccionarSueldoMayorANamed(sueldo);
    }

    public List<Profesor> buscarPorGeneroCriterial(String genero){
        return this.profesorRepository.seleccionarPorGeneroCriterial(genero);
    }

    public List<Profesor> buscarPorNombreEmpieceCon(String letra){
        return this.profesorRepository.seleccionarPorNombreEmpieceCon(letra);
    }

    public Long contarProfesores(){
        return this.profesorRepository.contarProfesores();
    }

    public List<Profesor> busquedaDinamica(String cedula, String nombre, String genero){
        return this.profesorRepository.seleccionarDinamicoCriterial(cedula, nombre, genero);
    }
}
