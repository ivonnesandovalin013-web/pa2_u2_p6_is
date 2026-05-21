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
            estudiante.setNombre("Nayely");
            estudiante.setApellido("Sandovalin");    
            estudiante.setFechaNacimiento(LocalDate.of(2001, 8, 3));
            estudiante.setGenero("F");

            //MÉTODO GUARDAR
            System.out.println( "MÉTODO GUARDAR");
            this.estudiante.guardar(estudiante);

            //MÉTODO BUSCAR
             System.out.println( "MÉTODO BUSCAR");
            Estudiante estudianteBuscar = this.estudiante.buscar(2);
            if(estudianteBuscar != null){
                System.out.println("Estudiante encontrado: " + estudianteBuscar.getNombre() + " " + estudianteBuscar.getApellido());
            }else{
                System.out.println("Estudiante no encontrado");
            }

            //MÉTODO ACTUALIZAR
             System.out.println( "MÉTODO ACTUALIZAR");
            if (estudianteBuscar != null) {
                 System.out.println("Estudiante encontrado: " + estudianteBuscar.getNombre() + " " + estudianteBuscar.getApellido());
    
                estudianteBuscar.setNombre("Ivonne");
                estudianteBuscar.setApellido("Tarco");
    
                this.estudiante.actualizar(estudianteBuscar);
    
                System.out.println("¡Estudiante actualizado correctamente en la base de datos!");

            } else {
                    System.out.println("Estudiante no encontrado");
            }
            
            //MÉTODO ELIMINAR
            System.out.println( "MÉTODO ELIMINAR");
            Estudiante estudianteEliminar = this.estudiante.buscar(1);
           if (estudianteEliminar != null) {
                 System.out.println("Estudiante encontrado: " + estudianteEliminar.getNombre() + " " + estudianteEliminar.getApellido());
    
                this.estudiante.eliminar(estudianteEliminar.getId());
    
                System.out.println("¡Estudiante eliminado correctamente de la base de datos!");

            } else {
                    System.out.println("Estudiante no encontrado, no se puede eliminar");
            }
            return 0;
        }
    }

}
