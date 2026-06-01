package ec.edu.uce;


import java.time.LocalDate;

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
            profesor1.setGradoAcademico("Phd");
            profesor1.setSueldo(2000);
            profesor1.setFechaIngreso(LocalDate.of(2001, 5, 27));
            profesor1.setCedula("1234567890");
            profesor1.setGenero("F");

            Profesor profesor2 = new Profesor();
            profesor2.setNombre("Nelly");
            profesor2.setApellido("Vela");
            profesor2.setAsignatura("Emprendimiento");
            profesor2.setGradoAcademico("Master");
            profesor2.setSueldo(1500);
            profesor2.setFechaIngreso(LocalDate.of(2005, 8, 15));
            profesor2.setCedula("0987654321");
            profesor2.setGenero("F");

            Profesor profesor3 = new Profesor();
            profesor3.setNombre("Carlos");
            profesor3.setApellido("Perez"); 
            profesor3.setAsignatura("Emprendimiento");
            profesor3.setGradoAcademico("Phd");
            profesor3.setSueldo(2500);
            profesor3.setFechaIngreso(LocalDate.of(2010, 3, 10));
            profesor3.setCedula("1122334455");
            profesor3.setGenero("M");

            //MÉTODO GUARDAR
            System.out.println( "MÉTODO GUARDAR");
            this.profesor.guardar(profesor1);
            this.profesor.guardar(profesor2);
            this.profesor.guardar(profesor3);

            //METODO BUSCAR POR CEDULA NATIVO
            System.out.println( "MÉTODO BUSCAR POR CEDULA NATIVO");
            Profesor profesorEncontrado = this.profesor.buscarPorCedulaNativo("1234567890");
            if (profesorEncontrado != null) {
                System.out.println("Profesor encontrado: " + profesorEncontrado.getNombre() + " " + profesorEncontrado.getApellido());
            } else {
                System.out.println("No se encontró ningún profesor con esa cédula.");
            }

            //METODO BUSCAR POR NOMBRE NATIVO
            System.out.println( "MÉTODO BUSCAR POR NOMBRE NATIVO");         
            for (Profesor p : this.profesor.buscarPorNombreNativo("Carlos")) {
                if (p != null) {
                    System.out.println("Profesor encontrado: " + p.toString());
                } else {
                    System.out.println("No se encontró ningún profesor con ese nombre.");
                }
            }

            //METODO BUSCAR POR GENERO NATIVO
            System.out.println( "MÉTODO BUSCAR POR GENERO NATIVO"); 
            for (Profesor p : this.profesor.buscarPorGeneroNativo("M")) {
                if (p != null) {
                    System.out.println("Profesor encontrado: " + p.toString());
                } else {
                    System.out.println("No se encontró ningún profesor con ese género.");
                }
            }

            return 0;
        }
    }

}
