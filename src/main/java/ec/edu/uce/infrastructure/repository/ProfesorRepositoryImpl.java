package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.TypedQueryReference;
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

}
        
    


