package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoServices;
import ec.edu.uce.application.service.EmpleadoServices;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Estudiante;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private CiudadanoServices ciudadanoService;
        @Inject
        private EmpleadoServices empleadoService;

        public int run(String... args) {
            
            Ciudadano c1 = new Ciudadano();
            c1.setNombre("Juan Perez");
            c1.setFechaNacimiento(LocalDateTime.of(2000, 1, 1, 15, 30));
            

            System.out.println("Metodo Guardar Ciudadano");
            this.ciudadanoService.guardar(c1);
            System.out.println("Ciudadano guardado con exito");

           /* System.out.println("Metodo Guardar Empleado");  
            
            Empleado em = new Empleado();
            em.setSalario(20000.0);
            em.setFechaIngreso(LocalDateTime.of(2020, 8, 4, 14, 30));
            
            em.setCiudadano(new Ciudadano());
            
            em.getCiudadano().setNombre("Genessis Molina");
            em.getCiudadano().setFechayHora(LocalDateTime.of(2003, 1, 1, 14, 30));
            
            this.empleadoService.guardar(em);*/

          
            Ciudadano c2 = new Ciudadano();
            c2.setNombre("Maria Gomez");
            c2.setFechaNacimiento(LocalDateTime.of(1995, 5, 20, 10, 0));
            //this.ciudadanoService.guardar(c2);

            //c2.setNombre("Jose Vidal");
            //System.out.println(c2.getId());

            Empleado e1 = new Empleado();
            e1.setCiudadano(c2);
            e1.setFechaIngreso(LocalDateTime.of(2025,02,01, 9,0));
            e1.setSalario(20000.0);
            this.empleadoService.guardar(e1);
        



                    


            return 0;
        }
    }

}
