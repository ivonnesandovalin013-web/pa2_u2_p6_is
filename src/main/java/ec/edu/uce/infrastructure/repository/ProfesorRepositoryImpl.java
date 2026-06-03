package ec.edu.uce.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;


import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.TypedQueryReference;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
    }

    @Override
    public Profesor seleccionar(Integer id) {
        return this.em.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.em.merge(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        Profesor profesor = this.em.find(Profesor.class, id);
        if (profesor != null) {
            this.em.remove(profesor);
        } else{
            System.out.println("Profesor no encontrado con id: " + id);
        }
    }

    @Override
    public List<Profesor> seleccionarPorAsignatura(String asignatura) {
        TypedQuery<Profesor> miQuery = this.em.createQuery(
            "SELECT p FROM Profesor p WHERE p.asignatura LIKE :asignatura", Profesor.class);
            miQuery.setParameter("asignatura","%" +asignatura+"%");
            return miQuery.getResultList();
            
    }

    @Override
    public Long contarPorGradoAcademico(String gradoAcademico) {
        TypedQuery<Long> miQuery = this.em.createQuery("SELECT COUNT(p) FROM Profesor p WHERE p.gradoAcademico LIKE :gradoAcademico", Long.class);
        miQuery.setParameter("gradoAcademico", "%" + gradoAcademico + "%");
        return miQuery.getSingleResult();
    }

    @Override
    public List<Profesor> seleccionarSueldoMayorA(Integer sueldo) {
       TypedQuery<Profesor> miQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.sueldo > :sueldo",Profesor.class);
       miQuery.setParameter("sueldo", sueldo);
       return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorAsignaturaNamed(String asignatura) {
        TypedQuery<Profesor> miQuery = this.em.createNamedQuery("Profesor.seleccionarPorAsignatura", Profesor.class);
        miQuery.setParameter("asignatura", "%" + asignatura + "%");
        return miQuery.getResultList();
    }

    @Override
    public Long contarPorGradoAcademicoNamed(String gradoAcademico) {
        TypedQuery<Long> miQuery = this.em.createNamedQuery("Profesor.contarPorGradoAcademico", Long.class);
        miQuery.setParameter("gradoAcademico", "%" + gradoAcademico + "%");
        return miQuery.getSingleResult();
    }

    @Override
    public List<Profesor> seleccionarSueldoMayorANamed(Integer sueldo) {
        TypedQuery<Profesor> miQuery = this.em.createNamedQuery("Profesor.seleccionarPorSueldoMayorA", Profesor.class);
        miQuery.setParameter("sueldo", sueldo);
        return miQuery.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorGeneroCriterial(String genero) {
        //1. Instancia de la clase que va a ser la constructora con CriterialBuilder
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        //2. Defino el tipo de objeto que va a retornar mi consulta.
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        //3. Defino las entidades que voy a usar en la consulta.
        Root<Profesor> root  = myQuery.from(Profesor.class);
        // La condicion de la consulta
        Predicate p1 = cb.equal(root.get("genero"), genero);
        //4. Defino que tipo de SQL voy a trabajar.
        myQuery.select(root).where(p1);

        //5. myQuery lo transformo a un query ejecutable.
        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorNombreEmpieceCon(String letra) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);
        //Predicado con like: Inicia (letra + "%"), Termina ("%" + letra), Que tenga esa letra en especifico("%" + letra + "%") y que sea exactamente(letra sin(%))
        Predicate p2 = cb.like(root.get("nombre"), letra +"%");
        myQuery.select(root).where(p2);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();


    }

    @Override
    public Long contarProfesores() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Long> mQuery = cb.createQuery(Long.class);
        Root<Profesor> root = mQuery.from(Profesor.class);
        mQuery.select(cb.count(root));

        TypedQuery<Long> query = this.em.createQuery(mQuery);
        return query.getSingleResult();
    }

    @Override
    public List<Profesor> seleccionarDinamicoCriterial(String cedula, String nombre, String genero) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);

        List<Predicate> condiciones = new ArrayList<>();

        if(cedula!= null){
            Predicate p1 = cb.equal(root.get("cedula"), cedula);
            condiciones.add(p1);
        }

        if(nombre != null){
            Predicate p2 = cb.like(root.get("nombre"), "%"+nombre+"%");
            condiciones.add(p2);
        }

        if(genero != null){
            Predicate p3 = cb.equal(root.get("genero"), genero);
            condiciones.add(p3);
        }

        myQuery.select(root).where(condiciones);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();
    }
    



}
        
    


