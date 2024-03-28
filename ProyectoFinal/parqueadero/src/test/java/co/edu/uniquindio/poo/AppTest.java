/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void crearParqueadero() {
        LOG.info("Iniciado test crear parqueadero");
        
        Parqueadero p1 = new Parqueadero(2,1500,1000);
        Propietario pr1 = new Propietario("sebastian","1094957292","3502790733");
        Vehiculo v1 = new Vehiculo("ljr689", 185,tipoVehiculo.CARRO,pr1);

        p1.agregarPropietario(pr1);
        p1.agregarVehiculo(v1);
        p1.agregarParqueo(v1,p1.getTarifaCarro());
        
        assertTrue(p1.getPropietarios().contains(pr1));
        assertTrue(p1.getVehiculos().contains(v1));

        assertEquals(true, p1.buscarVehiculoAlParqueadero("ljr689"));
        assertEquals(1, p1.getPropietarios().size());
        assertEquals(1, p1.getRegistros().size());
        assertEquals(1, p1.getVehiculos().size());
        LOG.info("Finalizando test crear parqueader");
    }

    @Test
    public void buscarVehiculo() 
    {
        LOG.info("Iniciado test buscar Vehiculo");
        
        Parqueadero p1 = new Parqueadero(2,1500,1000);
        Propietario pr1 = new Propietario("sebastian","1094957292","3502790733");
        Propietario pr2 = new Propietario("Joan","1094957292","3502790731");
        Vehiculo v1 = new Vehiculo("ljr689", 185,tipoVehiculo.CARRO,pr1);

        p1.agregarPropietario(pr1);
        assertThrows(Throwable.class, ()-> p1.agregarPropietario(pr2));
        LOG.info("Finalizando test buscar Vehiculo");
    }

    @Test
    public void finalizarRegristro() 
    {
        LOG.info("Iniciado test finalizar timempo parqueo");
        
        Parqueadero p1 = new Parqueadero(2,1500,1000);
        Propietario pr1 = new Propietario("sebastian","1094957292","3502790733");
        Vehiculo v1 = new Vehiculo("ljr689", 185,tipoVehiculo.CARRO,pr1);

        p1.agregarPropietario(pr1);
        p1.agregarVehiculo(v1);
        p1.agregarParqueo(v1,5000);
        assertEquals(1,p1.getRegistros().size());
        assertEquals(true, p1.buscarVehiculoAlParqueadero("ljr689"));
        p1.eliminarVehiculoAlParqueadero(v1);
        System.out.println("valor a pagar: " + p1.validarRegistroExistente("ljr689").getTotalPagar() +"tarifa; "+ p1.validarRegistroExistente("ljr689").getTarifa());
        LOG.info("Finalizando test timempo parqueo");
    }

    @Test
    public void buscarRegristroXY() 
    {
        LOG.info("Iniciado test iniciar buscar Regristro XY");
        
        Parqueadero p1 = new Parqueadero(2,1500,1000);
        Propietario pr1 = new Propietario("sebastian","1094957292","3502790733");
        Vehiculo v1 = new Vehiculo("ljr689", 185,tipoVehiculo.CARRO,pr1);

        p1.agregarPropietario(pr1);
        p1.agregarVehiculo(v1);
        p1.agregarParqueo(v1,5000);
        assertEquals(1,p1.getRegistros().size());
        assertEquals(true, p1.buscarVehiculoAlParqueadero("ljr689"));
        assertEquals("ljr689", p1.validarRegistroPorUbicacion(0, 0));
        p1.eliminarVehiculoAlParqueadero(v1);
        LOG.info("Finalizando test buscar Regristro XY");
    }

    @Test
    public void realizarReporteDiario() 
    {
        LOG.info("Iniciado test iniciar realizarReporteDiario");
        Collection<Registro> registroReporte = new LinkedList<Registro>();
        Parqueadero p1 = new Parqueadero(2,1500,1000);
        Propietario pr1 = new Propietario("sebastian","1094957292","3502790733");
        Vehiculo v1 = new Vehiculo("ljr689", 185,tipoVehiculo.CARRO,pr1);
        Propietario pr2 = new Propietario("sebastian1","10949572921","35027907331");
        Vehiculo v2 = new Vehiculo("ljr6891", 185,tipoVehiculo.CARRO,pr1);
        Propietario pr3 = new Propietario("sebastian2","10949572922","35027907332");
        Vehiculo v3 = new Vehiculo("ljr6892", 185,tipoVehiculo.CARRO,pr1);
        Propietario pr4 = new Propietario("sebastian3","10949572923","35027907333");
        Vehiculo v4 = new Vehiculo("ljr6893", 185,tipoVehiculo.CARRO,pr1);
        Propietario pr5 = new Propietario("sebastian4","10949572924","35027907334");
        Vehiculo v5 = new Vehiculo("ljr6894", 185,tipoVehiculo.CARRO,pr1);

        p1.agregarPropietario(pr1);
        p1.agregarVehiculo(v1);
        p1.agregarParqueo(v1,5000);
        p1.agregarPropietario(pr2);
        p1.agregarVehiculo(v2);
        p1.agregarParqueo(v2,5000);
        p1.agregarPropietario(pr3);
        p1.agregarVehiculo(v3);
        p1.agregarParqueo(v3,5000);
        p1.agregarPropietario(pr4);
        p1.agregarVehiculo(v4);
        p1.agregarParqueo(v4,5000);
        p1.agregarPropietario(pr5);
        p1.agregarVehiculo(v5);
        p1.agregarParqueo(v5,5000);

        //  "2024-03-26T05:10:00"
        registroReporte = p1.generarRegistroDiario("2024-03-26T01:00:00");
        assertEquals(5,registroReporte.size());
        
        LOG.info("Finalizando test realizarReporteDiario");
    }
}
