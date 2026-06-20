package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.CiudadanoServices;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.EmpleadoServices;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.MateriaService;
import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.model.Pedido;
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
        private AlumnoService alumnoService;

        @Inject
        private MateriaService materiaService;

        public int run(String... args) {
            
            System.out.println("Inicio Programa");
            //Sercive para alumnos y en cascada se inserta una lista de materias, por eso no hace falta a cada materia poner una lista de alunmos
            //Alumno que tomó 2 materias
           /* Alumno a1 = new Alumno();
            a1.setNombre("Ivonne");

            Materia m1 = new Materia();
            m1.setNombre("P. Avanzada");
            m1.setNumeroCreditos(4);

            Materia m2 = new Materia();
            m2.setNombre("P. Web");
            m2.setNumeroCreditos(6);

            List<Materia> listaMaterias = List.of(m1,m2);

            a1.setMaterias(listaMaterias);

            //Insert mediante services Alumno
            this.alumnoService.guardar(a1);*/
            //Ahora vamos a insertar en casda los alumnos a cada materia
            Materia m3 = new Materia();
            m3.setNombre("P. Distribuida");
            m3.setNumeroCreditos(8);

            Alumno a2 = new Alumno();
            a2.setNombre("Ivonne");
            a2.setMaterias(List.of(m3));
            Alumno a3 = new Alumno();
            a3.setNombre("Nayely");
            a3.setMaterias(List.of(m3));
            m3.setAlumnos(List.of(a2,a3));

            this.materiaService.guardar(m3);

            //Consulta por Id de materia.
            //Imprimir los alumnos inscritos a una materia
            System.out.println("Alumnos de la materia de P. Distribuida");

            Materia materiaBuscar = this.materiaService.buscar(4);
            if(materiaBuscar != null){
                System.err.println("Materia encontrada");
                for (Alumno alumno : materiaBuscar.getAlumnos()) {
                System.out.println(" -> ID: " + alumno.getId() + " | Nombre: " + alumno.getNombre()+" | Materia: "+ materiaBuscar.getNombre());
                } 
            }

            //Que materia esta tomando el alumno
            Alumno alumnoBuscar = this.alumnoService.buscar(2);

            if (alumnoBuscar != null) {
                System.out.println("Alumno encontrado");
                for(Materia materia : alumnoBuscar.getMaterias()){
                    System.out.println(" -> ID: " + materia.getId() + " | Nombre: " + materia.getNombre()+" | Materia: "+ alumnoBuscar.getNombre());
                }
            }



            return 0;
        }
    }

}
