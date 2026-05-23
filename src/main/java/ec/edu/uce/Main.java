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
            estudiante.setFechaNacimiento(LocalDate.of(2001, 8, 3));
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
            estudiante3.setFechaNacimiento(LocalDate.of(1998, 2, 23));
            estudiante3.setGenero("M");

            //MÉTODO GUARDAR
            System.out.println( "MÉTODO GUARDAR");
            this.estudiante.guardar(estudiante);
            this.estudiante.guardar(estudiante2);
            this.estudiante.guardar(estudiante3);
        

            //METODO BUSCAR TODOS
           /*  System.out.println( "MÉTODO BUSCAR TODOS");
            System.out.println("Lista de estudiantes:");
            for (Estudiante e : this.estudiante.buscarTodos()) {
                System.out.println(e.toString());
            }

            //METODO CONSULTAR POR NOMBRE
            System.out.println( "MÉTODO CONSULTAR POR NOMBRE");
            System.out.println("Lista de estudiantes con el nombre 'Nayely':");
            for(Estudiante e: this.estudiante.consultarPorNombre("Nayely")){
                System.out.println(e.toString());
            }*/

            //METODO CONSULTAR POR CEDULA
            System.out.println("METODO CONSULTAR POR CEDULA");
            System.out.println("Estudiante con celdula '1752152924' : ");
            System.out.println(this.estudiante.consultarPorCedula("1752152924"));
    




            return 0;
        }
    }

}
