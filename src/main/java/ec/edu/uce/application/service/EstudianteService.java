package ec.edu.uce.application.service;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstudianteService { //Programamos todos los casos de uso de Estudiante, y toda la logica de negocio.
    @Inject
    private EstudianteRepository estudianteRepository; //Inyectamos la dependencia del repositorio, para poder utilizar sus métodos y realizar las operaciones necesarias en la base de datos.
    public void guardar(Estudiante estudiante){
        this.estudianteRepository.crear(estudiante); //Llamamos al método crear del repositorio para guardar el estudiante en la base de datos.
    }

    public Estudiante buscar(Integer id){
        return this.estudianteRepository.seleccionar(id); //Llamamos al método seleccionar del repositorio para buscar un estudiante por su id en la base de datos.
    }

    public void actualizar(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante); //Llamamos al método actualizar del repositorio para actualizar un estudiante en la base de datos.
    }

    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id); //Llamamos al método eliminar del repositorio para eliminar un estudiante por su id en la base de datos.
    }

    public List<Estudiante> buscarTodos(){
        return this.estudianteRepository.seleccionarTodos();
    }

    public List<Estudiante> consultarPorNombre(String nombre){
        return this.estudianteRepository.seleccionarPorNombre(nombre);
    }

    public Estudiante consultarPorCedula(String cedula){
        return this.estudianteRepository.seleccionarPorCedula(cedula);
    }

    public List<Estudiante> consultarPorGenero(String genero){
        return this.estudianteRepository.seleccionarPorGenero(genero);
    }

    public List<Estudiante> consultarPorGeneroTyped(String genero){
        return this.estudianteRepository.seleccionarPorGeneroTyped(genero);
    }

    public List<Estudiante> consultarPorRangoFechas(LocalDate fechaIncio, LocalDate fechaFin){
        return this.estudianteRepository.seleccionarPorRangoFechas(fechaIncio, fechaFin);
    }

    public List<Estudiante> consultarPorApellido(String apellido){
        return this.estudianteRepository.seleccionarPorApellido(apellido);
    }

    public Long consultarContar(){
        return this.estudianteRepository.seleccionarContar();
    }

    public List<Estudiante> consultarTodosNative(){
        return this.estudianteRepository.seleccionarTodosNative();
    }

}
