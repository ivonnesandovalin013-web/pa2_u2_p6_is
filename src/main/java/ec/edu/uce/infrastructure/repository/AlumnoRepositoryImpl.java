package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AlumnoRepositoryImpl implements AlumnoRepository {
    @Inject
    private EntityManager em;

    @Override
    public void crear(Alumno alumno) {
        this.em.persist(alumno);
    }

    @Override
    public Alumno seleccionar(Integer id) {
       return this.em.find(Alumno.class, id);
    }

}
