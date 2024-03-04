package co;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.AppTest;
import co.edu.uniquindio.poo.Mascota;
import co.edu.uniquindio.poo.Veterinaria;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;


public class VeterinariaTest {
        
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * pruenas unitarias Veterinaria -> mascota
     */
    @Test
    public void datosCompletos()
    {
        LOG.info("Iniciado test datosCompletos");
        Veterinaria v1 = new Veterinaria("Veterianaria I");
        assertEquals("Veterianaria I", v1.getNombre());
        LOG.info("Finalizando test datosCompletos");
    }

    @Test
    public void agregarMascota(){
        LOG.info("Iniciando test agregarMascota");

        Veterinaria v1 = new Veterinaria("Veterinaria I");
        Mascota mascota = new Mascota("Mateo","Perro","Bernes de la montaña","Masculino","Negro,blanco,cafe","1094957292",25,2);

        v1.agregarMascotas(mascota);
        assertTrue(v1.getMascotas().contains(mascota));
        assertEquals(1, v1.getMascotas().size());

        LOG.info("Finalizando test agregarEstudiante");
    }

    @Test
    public void datosNulos() {

        LOG.info("Iniciado test datosnulos");
        assertThrows(Throwable.class, ()-> new Veterinaria(null));
        LOG.info("Finalizando test datosNulos");
    }
    @Test
    public void agregarMascotaRepetido() {

        LOG.info("Iniciado test agregarMascotaRepetido");
        var v = new Veterinaria("Veterianaria I");
        Mascota mascota1 = new Mascota("Mateo","Perro","Bernes de la montaña","Masculino","Negro,blanco,cafe","1094957292",25,2);
        Mascota mascota2 = new Mascota("Chocolate","Perro","Bernes de la montaña","Masculino","Negro,blanco,cafe","1094957292",25,2);
        v.agregarMascotas(mascota1);

        assertThrows(Throwable.class, ()-> v.agregarMascotas(mascota2));

        LOG.info("Finalizando test agregarMascotaRepetido");
    }

    @Test
    public void agregarVeterinaria(){
        LOG.info("Iniciando test agregarVeterinaria");
        Veterinaria v1 = new Veterinaria("Veterianaria II"); 
        assertEquals("Veterianaria II", v1.getNombre());
        LOG.info("Finalizando test agregarVeterinaria");
    }
}
