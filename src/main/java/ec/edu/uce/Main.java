package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.CiudadanoServices;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.EmpleadoServices;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Estudiante;
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
        private ClienteService clienteService;

        public int run(String... args) {
            
            System.out.println("Inicio Programa");

            Cliente c1 = new Cliente();
            c1.setNombre("Nayely");
            c1.setCedula("175214896");

            Pedido p1 = new Pedido();
            p1.setTotal(Double.valueOf(10));
            p1.setCliente(c1);
            p1.setFecha(LocalDate.of(2026, 10, 10));

            Pedido p2 = new Pedido();
            p2.setTotal(Double.valueOf(100));
            p2.setCliente(c1);
            p2.setFecha(LocalDate.of(2026, 5, 1));

            List<Pedido> pedidos = new ArrayList<>();
            pedidos.add(p1);
            pedidos.add(p2);

            c1.setPedidos(pedidos);

            this.clienteService.guardar(c1);
         
            System.out.println("Cliente: "+c1);

            return 0;
        }
    }

}
