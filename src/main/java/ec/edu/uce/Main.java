package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoServices;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
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

        public int run(String... args) {
            
            Ciudadano c1 = new Ciudadano();
            c1.setNombre("Juan Perez");
            c1.setFechaNacimiento(LocalDateTime.of(2000, 1, 1, 15, 30));
            

            System.out.println("Metodo Guardar Ciudadano");
            this.ciudadanoService.guardar(c1);
            System.out.println("Ciudadano guardado con exito");


            return 0;
        }
    }

}
