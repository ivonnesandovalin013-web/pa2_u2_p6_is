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

            Profesor profesor2 = new Profesor();
            profesor2.setNombre("Nelly");
            profesor2.setApellido("Vela");
            profesor2.setAsignatura("Emprendimiento");
            profesor2.setGradoAcademico("Master");
            profesor2.setSueldo(1500);
            profesor2.setFechaIngreso(LocalDate.of(2005, 8, 15));

            Profesor profesor3 = new Profesor();
            profesor3.setNombre("Carlos");
            profesor3.setApellido("Perez"); 
            profesor3.setAsignatura("Emprendimiento");
            profesor3.setGradoAcademico("Phd");
            profesor3.setSueldo(2500);
            profesor3.setFechaIngreso(LocalDate.of(2010, 3, 10));

            //MÉTODO GUARDAR
            System.out.println( "MÉTODO GUARDAR");
            this.profesor.guardar(profesor1);
            this.profesor.guardar(profesor2);
            this.profesor.guardar(profesor3);

            //METODO SELECCIONAR POR ASIGNATURA NAMEDQUERY
            System.out.println( "MÉTODO SELECCIONAR POR ASIGNATURA NAMEDQUERY");
            for(Profesor p : this.profesor.buscarPorAsignaturaNamed("Emprendimiento")){
                System.out.println(p.getNombre() + " " + p.getApellido());
            }

             //METODO CONTAR POR GRADO ACADEMICO NAMEDQUERY
             System.out.println( "MÉTODO CONTAR POR GRADO ACADEMICO NAMEDQUERY");
             Long count = this.profesor.contarPorGradoAcademicoNamed("Phd");
             System.out.println("Número de profesores con grado académico Phd: " + count);

              //METODO SELECCIONAR SUELDO MAYOR A NAMEDQUERY
              System.out.println( "MÉTODO SELECCIONAR SUELDO MAYOR A NAMEDQUERY");
              for(Profesor p : this.profesor.buscarSueldosMayoresANamed(1800)){
                  System.out.println(p.getNombre() + " " + p.getApellido() + " - Sueldo: " + p.getSueldo());
              }

            return 0;
        }
    }

}
