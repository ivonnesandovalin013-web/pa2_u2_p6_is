package ec.edu.uce;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.DesarrolladorService;
import ec.edu.uce.application.service.ProyectoService;
import ec.edu.uce.domain.model.Desarrollador;
import ec.edu.uce.domain.model.Proyecto;
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
        private DesarrolladorService desarrolladorService;

        @Inject
        private ProyectoService proyectoService;

        public int run(String... args) {
            System.out.println("Iniciando el proograma");

            //Sercive para desarrolladores y en cascada se inserta una lista 
            // de proyectos, por eso no hace falta a cada proyecto poner una 
            // lista de desarrolladores

            /*Desarrollador d1 = new Desarrollador();
            d1.setNombre("Nayely");
            d1.setRol("Backend Developer");
            d1.setFechaIngreso(LocalDate.of(2020, 05, 02));

            Proyecto p1 = new Proyecto();
            p1.setNombre("AuraDent IA");

            Proyecto p2 = new Proyecto();
            p2.setNombre("Robot");

            List<Proyecto> listaProyectos = List.of(p1,p2);

            d1.setProyectos(listaProyectos);

            this.desarrolladorService.guardar(d1);*/
            
            //Ahora vamos a insertar en cascada los desarrolladores a cada proyecto
            /*Proyecto p3 = new Proyecto();

            p3.setNombre("KriptaDent IA");

            Desarrollador d2 = new Desarrollador();
            d2.setNombre("Genesis");
            d2.setRol("Backend Developer");
            d2.setFechaIngreso(LocalDate.of(2019, 06, 03));
            d2.setProyectos(List.of(p3));


            Desarrollador d3 = new Desarrollador();
            d3.setNombre("Miguel");
            d3.setRol("Backend Developer");
            d3.setFechaIngreso(LocalDate.of(2018, 05, 02));
            d3.setProyectos(List.of(p3));

            p3.setDesarrolladors(List.of(d2,d3));

            this.proyectoService.guardar(p3);*/

            //Consulta por Id de pryecto.
            //Imprimir los desarrolles encargados de un proyecto.

            System.out.println("Desarrolladores en proyecto de KriptaDent");
            
            Proyecto proyectoBuscar = this.proyectoService.buscar(3);

            if(proyectoBuscar != null){
                System.out.println("Proyecto encontrado");
                for(Desarrollador desarrolladores : proyectoBuscar.getDesarrolladors()){
                    System.out.println("-> ID: "+ desarrolladores.getId() + " |Nombre: " + desarrolladores.getNombre() + " |Proyecto: "+ desarrolladores.getProyectos());
                }
            }

             //En que proyectos está el desallorador 
             Desarrollador desarrolladorBuscar = this.desarrolladorService.buscar(2);
             if(desarrolladorBuscar != null){
                System.out.println("Desarrollador encontrado");
                for(Proyecto proyectos : desarrolladorBuscar.getProyectos()){
                    System.out.println("-> ID: "+ proyectos.getId() + " |Nombre: " + proyectos.getNombre() + " |Proyecto: "+ proyectos.getDesarrolladors());
                }
            }


            return 0;
        }
    }

}
