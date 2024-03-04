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
    public void datosCompletos() {
        Mascota m1 = new Mascota("Mateo","Perro","Bernes de la montaña","Masculino","Negro,blanco,cafe","1094957292",25,2);
        LOG.info("Iniciado test datosCompletos");
        assertEquals("Mateo",m1.getNombre());
        LOG.info("Finalizando test datosCompletos");
    }

    @Test
    public void datosNulos() {

        LOG.info("Iniciado test nulos");
        assertThrows(Throwable.class, ()-> new Mascota(null, null, null, null, null,null, 0, 0));
        LOG.info("Finalizando test datosNulos");
    }

    @Test
    public void datosVacios() {
        LOG.info("Iniciado test vacios");
        assertThrows(Throwable.class, ()-> new Mascota(" ", " ", " ", " ", " "," ",0,0));
        LOG.info("Finalizando test vacios");

    }

    @Test
    public void edadNegativa() {
        LOG.info("Iniciado test edad Negativa");

        assertThrows(Throwable.class, ()-> new Mascota("Mateo","Perro","Bernes de la montaña","Masculino","Negro,blanco,cafe","1094957292",-25,2));

        LOG.info("Finalizando test edad no es negativa");

    }

    @Test
    public void pesoNegativo() {
        LOG.info("Iniciado test PesoNegativo");

        assertThrows(Throwable.class, ()-> new Mascota("Mateo","Perro","Bernes de la montaña","Masculino","Negro,blanco,cafe","1094957292",25,-2));

        LOG.info("Finalizando test PesoNegativo");

    }
}
