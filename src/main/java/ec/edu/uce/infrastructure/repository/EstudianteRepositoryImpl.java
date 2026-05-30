package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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

     //1. Query (JPQL QUERY)
    //1.1 TypedQuery: tiene un tipado, sabemos que tipo de consulta u objeto con el que voy a trabajar. En los 2 casos usamos JPQL
    @Override
    public List<Estudiante> seleccionarTodos() {
       TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
       return miQuery.getResultList(); //El método getResultList() se utiliza para ejecutar la consulta y obtener una lista de resultados. En este caso, se está obteniendo una lista de objetos de tipo Estudiante que cumplen con la consulta JPQL definida en el método createQuery().
    }

    @Override
    public List<Estudiante> seleccionarPorNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre1 ", 
        Estudiante.class); //los 2 puntos nos dice que viene el nombre de una variable, y esa variable se remplaza por un valor. 
        miQuery.setParameter("nombre1", nombre); //nombre del atributo como varialble
        return miQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula",
        Estudiante.class); 
        miQuery.setParameter("cedula", cedula);
        //return miQuery.getSingleResult(); //El método getSingleResult() se utiliza para ejecutar la consulta y obtener un único resultado. En este caso, se espera que la consulta retorne un solo objeto de tipo Estudiante que cumpla con la condición de tener la cédula especificada. Si la consulta retorna más de un resultado o ningún resultado, se lanzará una excepción.
        //return miQuery.getResultList().get(0);
        //return miQuery.getResultList().getFirst();
        return miQuery.getResultList().getLast();
    }

    //1.2 NamedQuery: es una consulta que esta predefinida y que voy a poder reutilizarla.
    @Override
    public List<Estudiante> seleccionarPorGenero(String genero) {
        Query myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero");
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorGeneroTyped(String genero) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
        miQuery.setParameter("genero", genero);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorRangoFecha", Estudiante.class);
        miQuery.setParameter("inicio", fechaInicio);
        miQuery.setParameter("fin", fechaFin);
        return miQuery.getResultList();
    }

    @Override
    public List<Estudiante> seleccionarPorApellido(String apellido) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorApellido", Estudiante.class);
        miQuery.setParameter("apellido", apellido);
        return miQuery.getResultList();
    }

    @Override
    public Long seleccionarContar() {
        TypedQuery<Long> miQuery = this.em.createNamedQuery("Estudiante.contar", Long.class);
        return miQuery.getSingleResult();
    }



}
    

   
    



