package ec.edu.uce.application.service;

import java.time.LocalDateTime;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
//@Transactional
public class EmpleadoServices {

    @Inject
    private EmpleadoRepository empleadoRepository;

    @Inject
    private CiudadanoServices ciudadanoService;
    @Transactional
    public void guardar(Empleado empleado) {

        Ciudadano c2 = new Ciudadano();
            /*c2.setNombre("Maria Gomez");
            c2.setFechaNacimiento(LocalDateTime.of(1995, 5, 20, 10, 0));
            this.ciudadanoService.guardar(c2);
            c2.setNombre("Jose Lopez");
            empleado.setCiudadano(c2);*/
        this.empleadoRepository.crear(empleado);
    }



    

}
