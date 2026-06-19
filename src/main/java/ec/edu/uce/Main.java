package ec.edu.uce;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.AutomovilService;
import ec.edu.uce.application.service.ComputadoraService;
import ec.edu.uce.application.service.MotorServices;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Automovil;
import ec.edu.uce.domain.model.Componente;
import ec.edu.uce.domain.model.Computadora;
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
        private ComputadoraService computadora;

        public int run(String... args) {
            System.out.println("Iniciando el proograma");
            Computadora c = new Computadora();
            c.setMarca("ASUS");
            c.setModelo("Vivobook");

            Componente componente1 = new Componente();
            componente1.setNombre("ASUS TUF Gaming B650-Plus WiFi");
            componente1.setTipo("Placa Base");

            Componente componente2 = new Componente();
            componente2.setNombre("Intel Iris Xe Graphics");
            componente2.setTipo("Tarjeta Gráfica");

            Componente componente3 = new Componente();
            componente3.setNombre("8GB DDR4 (Onboard)");
            componente3.setTipo("RAM");

            List<Componente> componentes = new ArrayList<>();
            componentes.add(componente1);
            componentes.add(componente2);
            componentes.add(componente3);

            c.setComponentes(componentes);

            this.computadora.guardar(c);

            System.out.println("Computadora guardada: "+ c);

           

            return 0;
        }
    }

}
