package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional //Esta clase esta destinada a conectarse con la base de datos debe haber una transaccion.
public class EstudianteRepositoryImpl implements EstudianteRepository {
    @Inject //El contenedor se encarga de inyectar la dependencia, es decir, de crear una instancia de EntityManager y asignarla a esta variable.
    private EntityManager em; //Clase principal que nos va a pemitir gestionar la implementacion ORM, nos la provee el contenedor.

    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante); //El método para persistir es persist() se utiliza para guardar una nueva entidad en la base de datos. En este caso, se está guardando un objeto de tipo Estudiante.
    }

    @Override
    public Estudiante seleccionar(Integer id) {
        return this.em.find(Estudiante.class, id); //para buscar una entidad por su clave primaria, se utiliza el método find() del EntityManager. En este caso, se está buscando un objeto de tipo Estudiante con un id específico.
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante); //El método merge() se utiliza para actualizar una entidad existente. Cuando yo hago un merge la entidad si o si debe tener su dato de clave primaria, porque el merge lo que hace es buscar la entidad en la base de datos por su id y actualizarla con los nuevos valores que le estoy pasando. Si el objeto no tiene un id, el merge no va a saber qué entidad actualizar y va a lanzar una excepción.
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionar(id)); //El método remove() se utiliza para eliminar una entidad de la base de datos. En este caso, se está eliminando un objeto de tipo Estudiante que se obtiene previamente mediante el método seleccionar(id).
    }

}

