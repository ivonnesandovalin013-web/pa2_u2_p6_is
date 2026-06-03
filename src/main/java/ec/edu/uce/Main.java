package ec.edu.uce;


import java.time.LocalDate;

import ec.edu.uce.application.service.ProfesorService;
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
        private ProfesorService profesor;

        public int run(String... args) {
            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Dagaly");
            profesor1.setApellido("Diaz");
            profesor1.setAsignatura("Hisotoria");
            profesor1.setGradoAcademico("Phd");
            profesor1.setSueldo(2000);
            profesor1.setFechaIngreso(LocalDate.of(2001, 5, 27));
            profesor1.setGenero("F");
            profesor1.setCedula("1752152926");

            Profesor profesor2 = new Profesor();
            profesor2.setNombre("Nelly");
            profesor2.setApellido("Vela");
            profesor2.setAsignatura("Emprendimiento");
            profesor2.setGradoAcademico("Master");
            profesor2.setSueldo(1500);
            profesor2.setFechaIngreso(LocalDate.of(2005, 8, 15));
            profesor2.setGenero("F");
            profesor2.setCedula("0987456123");

            Profesor profesor3 = new Profesor();
            profesor3.setNombre("Darlos");
            profesor3.setApellido("Perez"); 
            profesor3.setAsignatura("Emprendimiento");
            profesor3.setGradoAcademico("Phd");
            profesor3.setSueldo(2500);
            profesor3.setFechaIngreso(LocalDate.of(2010, 3, 10));
            profesor3.setGenero("M");
            profesor3.setCedula("2583691479");

            Profesor profesor4 = new Profesor();
            profesor4.setNombre("Hugo");
            profesor4.setApellido("Chavez"); 
            profesor4.setAsignatura("Educacion Fisica");
            profesor4.setGradoAcademico("Master");
            profesor4.setSueldo(1000);
            profesor4.setFechaIngreso(LocalDate.of(1998, 6, 10));
            profesor4.setGenero("M");
            profesor4.setCedula("1234567895");

            //MÉTODO GUARDAR
            System.out.println( "MÉTODO GUARDAR");
            this.profesor.guardar(profesor1);
            this.profesor.guardar(profesor2);
            this.profesor.guardar(profesor3);
            this.profesor.guardar(profesor4);

           //METODO BUSCAR POR GENERO
           System.out.println("BUSCAR POR GENERO");
           for(Profesor p: this.profesor.buscarPorGeneroCriterial("M")){
            System.out.println("Profesor/es encontrados: ");
            System.out.println(p.toString());
           }

           //METODO BUSCAR POR NOMBRE QUE EMPIECE CON
           System.out.println("BUSCAR POR NOMBRE QUE EMPIECE CON");
           for(Profesor p: this.profesor.buscarPorNombreEmpieceCon("D")){
            System.out.println("Profesor encontrados: ");
            System.out.println(p.toString());
           }

           //METODO CONTAR PROFESORES
           System.out.println("CONTAR PROFESORES");
           System.out.println("La cantidad de profesores es: "+this.profesor.contarProfesores());

           //METODO DINAMICO
           System.out.println("METODO DINAMICO");
           System.out.println("Por nombre y genero");
           for(Profesor p : this.profesor.busquedaDinamica(null, "Darlos", "M")){
            System.out.println("Profesor encontrado: "+ p);
           }
           System.out.println("Por cedula y genero");
           for(Profesor p: this.profesor.busquedaDinamica("1752152926", null, "F"))
            System.out.println("Profesor encontrado: "+ p.toString());
           System.out.println("Por cedula y nombre");
           for(Profesor p: this.profesor.busquedaDinamica("0987456123", "Nelly", null)){
             System.out.println("Profesor encontrado: "+ p.toString());
           }
           System.out.println("Por cedula, nombre y genero");
           for(Profesor p: this.profesor.busquedaDinamica("1234567895", "Hugo", "M")){
            System.out.println("Profesor encontrado: "+ p.toString());
           }

            return 0;
        }
    }

}
