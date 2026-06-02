package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.EstudianteService;
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
        private EstudianteService estudiante;

        public int run(String... args) {
            Estudiante estudiante = new Estudiante();
            estudiante.setCedula("1752152924");
            estudiante.setNombre("Nayely");
            estudiante.setApellido("Sandovalin");    
            estudiante.setFechaNacimiento(LocalDate.of(2010, 8, 3));
            estudiante.setGenero("F");

            Estudiante estudiante2 = new Estudiante();
            estudiante2.setCedula("1752152924");
            estudiante2.setNombre("Lesly");
            estudiante2.setApellido("Vela");    
            estudiante2.setFechaNacimiento(LocalDate.of(2004, 2, 22));
            estudiante2.setGenero("F");

            Estudiante estudiante3 = new Estudiante();
            estudiante3.setCedula("1711969715");
            estudiante3.setNombre("Marco");
            estudiante3.setApellido("Vela");    
            estudiante3.setFechaNacimiento(LocalDate.of(2015, 2, 23));
            estudiante3.setGenero("M");

            //MÉTODO GUARDAR
            System.out.println( "MÉTODO GUARDAR");
            this.estudiante.guardar(estudiante);
            this.estudiante.guardar(estudiante2);
            this.estudiante.guardar(estudiante3);
        
            //METODO CONSULTAR TODOS CRITERIAL
            System.out.println( "MÉTODO CONSULTAR TODOS CRITERIAL");
            System.out.println( "Lista de estudiantes: ");
            for(Estudiante e: this.estudiante.consultarTodosCriterial()){
                System.out.println( e.toString());
            }

            //MÉTODO CONSULTAR POR NOMBRE CRITERIAL
            System.out.println( "MÉTODO CONSULTAR POR NOMBRE CRITERIAL");
            for(Estudiante e: this.estudiante.consultarPorNombreCriterial("Lesly")){
                System.out.println("Estudiante encontrado: "+ e.toString());
            }

            //METODO CONSULTAR DINAMICO CRITERIAL
            System.out.println( "MÉTODO CONSULTAR DINAMICO CRITERIAL");
            System.out.println("----Por nombre y apellido-----");
            for(Estudiante e: this.estudiante.consultarDinamicoCriterial("Lesly", "Vela")){
                System.out.println("Estudiante encontrado: "+ e.toString());
            }
            System.out.println("----Por nombre----");
            for(Estudiante e: this.estudiante.consultarDinamicoCriterial("Lesly", null)){
                System.out.println("Estudiante encontrado: "+ e.toString());
            }
            System.out.println("----Por apellido----");
             for(Estudiante e: this.estudiante.consultarDinamicoCriterial(null, "Vela")){
                System.out.println("Estudiante encontrado: "+ e.toString());
            }
            System.out.println("----Por ambos null----");
            for(Estudiante e: this.estudiante.consultarDinamicoCriterial(null, null)){
                System.out.println("Estudiante encontrado: "+ e.toString());
            }


            return 0;
        }
    }

}
