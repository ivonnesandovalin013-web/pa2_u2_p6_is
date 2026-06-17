package ec.edu.uce;


import java.time.LocalDate;

import ec.edu.uce.application.service.AutomovilService;
import ec.edu.uce.application.service.MotorServices;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Automovil;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Motor;
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

        @Inject
        private MotorServices motor;

        public int run(String... args) {


            Automovil a1 = new Automovil();

            a1.setChasis(12345);
            a1.setModelo("500");
            a1.setMarca("fiat");
            a1.setColor("celeste");

            System.out.println("Guardando automovil");
            this.automovil.guardar(a1);

            System.out.println("Guardado "+a1);

            /*
            System.out.println("--- ESCENARIO 2: Guardando Motor con Auto no persistido ---");
            
            Motor mot1 = new Motor();
            mot1.setNumeroSerie("MOT-999-XYZ");
            mot1.setCilindraje("2.0");
            
            // Le pasamos un auto que vive en memoria pero que NO se ha guardado en la BD
            mot1.setAutomovil(new Automovil());
            mot1.getAutomovil().setChasis(77777);
            mot1.getAutomovil().setMarca("Chevrolet");
            mot1.getAutomovil().setModelo("Sail");
            mot1.getAutomovil().setColor("Azul");

            this.motorService.guardar(mot1); 
            */

           System.out.println("--- ESCENARIO 3: Guardando con violación de NOT NULL ---");
        
            Automovil auto2 = new Automovil();
            auto2.setChasis(987654);
            auto2.setMarca("Hyundai");
            auto2.setModelo("Tucson");
            auto2.setColor("Negro");
            //this.automovil.guardar(auto2);

            Motor mot2 = new Motor();
            mot2.setNumeroSerie("EAD2345"); 
            mot2.setCilindraje("1.6");
            
            // Asociamos el automóvil
            mot2.setAutomovil(auto2);

            this.motor.guardar(mot2);

            return 0;
        }
    }

}
