package ec.edu.uce;


import java.time.LocalDate;

import ec.edu.uce.application.service.AutomovilService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Automovil;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Profesor;
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
        private AutomovilService automovil;

        public int run(String... args) {
            Automovil a1 = new Automovil();

            a1.setChasis(12345);
            a1.setModelo("500");
            a1.setMarca("fiat");
            a1.setColor("celeste");

            System.out.println("Guardando automovil");
            this.automovil.guardar(a1);

            System.out.println("Guardado "+a1);

            return 0;
        }
    }

}
