package ec.edu.uce;


import ec.edu.uce.application.service.ProfesorService;
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
        private ProfesorService profesor;

        public int run(String... args) {
            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Magaly");
            profesor1.setApellido("Diaz");
            profesor1.setAsignatura("Hisotoria");

            Profesor profesor2 = new Profesor();
            profesor2.setNombre("Nelly");
            profesor2.setApellido("Vela");
            profesor2.setAsignatura("Emprendimiento");

            //MÉTODO GUARDAR
            System.out.println( "MÉTODO GUARDAR");
            this.profesor.guardar(profesor1);
            this.profesor.guardar(profesor2);

            //MÉTODO BUSCAR
             System.out.println( "MÉTODO BUSCAR");
            Profesor profesorBuscar = this.profesor.buscar(2);
            if(profesorBuscar != null){
                System.out.println("Profesor encontrado: " + profesorBuscar.getNombre() + " " + profesorBuscar.getApellido());
            }else{
                System.out.println("Profesor no encontrado");
            }

            //MÉTODO ACTUALIZAR
             System.out.println( "MÉTODO ACTUALIZAR");
            if (profesorBuscar != null) {
                 System.out.println("Profesor encontrado: " + profesorBuscar.getNombre() + " " + profesorBuscar.getApellido());
    
                profesorBuscar.setNombre("Ivonne");
    
                this.profesor.actualizar(profesorBuscar);
    
                System.out.println("¡Profesor actualizado correctamente en la base de datos!");

            } else {
                    System.out.println("Profesor no encontrado");
            }
            
            //MÉTODO ELIMINAR
            System.out.println( "MÉTODO ELIMINAR");
            Profesor profesorEliminar = this.profesor.buscar(1);
           if (profesorEliminar != null) {
                 System.out.println("Profesor encontrado: " + profesorEliminar.getNombre() + " " + profesorEliminar.getApellido());
    
                this.profesor.eliminar(profesorEliminar.getId());
    
                System.out.println("¡Profesor eliminado correctamente de la base de datos!");

            } else {
                    System.out.println("Profesor no encontrado, no se puede eliminar");
            }
            return 0;
        }
    }

}
