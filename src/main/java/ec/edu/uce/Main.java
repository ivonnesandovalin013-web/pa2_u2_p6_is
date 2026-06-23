package ec.edu.uce;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.CuentaBancariService;
import ec.edu.uce.application.service.DesarrolladorService;
import ec.edu.uce.application.service.ProyectoService;
import ec.edu.uce.application.service.TransferenciaService;
import ec.edu.uce.domain.model.CuentaBancaria;
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
        private CuentaBancariService cuentaBancariService;
        @Inject
        private TransferenciaService transferenciaService;

        public int run(String... args) {
            System.out.println("Iniciando el proograma");

            CuentaBancaria c1 = new CuentaBancaria();
            c1.setNumeroCuenta("2203256014");
            c1.setSaldo(new BigDecimal(500));
            this.cuentaBancariService.guardar(c1);
            
            CuentaBancaria c2 = new CuentaBancaria();
            c2.setNumeroCuenta("2325147874");
            c2.setSaldo(new BigDecimal(800));
            this.cuentaBancariService.guardar(c2);

            System.out.println("Iniciando Transferencia");
            try {
                this.transferenciaService.registrarTransferencia(1, 2, new BigDecimal(50));
                System.out.println("Transferencia realizada");
            } catch (Exception e) {
                System.out.println("Error en la transferencia: " + e.getMessage());
            }

            return 0;
        }
    }

}
