package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class TicketTest {
    
    private static final Logger LOG = Logger.getLogger(TicketTest.class.getName()); 
    
    
    @Test
    public void datosCompletos() 
    {
        LOG.info("Iniciado test datosCompletos");
        LocalDateTime x = LocalDateTime.now();

        Ticket t1 = new Ticket(x,"Superman",25000);
        assertEquals("Superman",t1.getnombreFuncion());
        System.out.println(t1.toString());
        LOG.info("Finalizando test buscarPerson");
    }

    @Test
    public void datosNulos() 
    {
        LOG.info("Iniciado test datosNulos");

        LocalDateTime x = LocalDateTime.now();
        assertThrows(Throwable.class, ()-> new Ticket(null, null,0));

        LOG.info("Finalizando test datosNulos");
    }

    @Test
    public void datosVacios() {
        LOG.info("Iniciado test vacios");
        //como colocar vacio en un date
        assertThrows(Throwable.class, ()-> new Ticket(null, " ", 0));
        LOG.info("Finalizando test vacios");

    }

    @Test
    public void validarPrecio() {} 
    {
        LOG.info("Iniciado test validarPrecio");
        LocalDateTime x = LocalDateTime.now();

        Ticket t1 = new Ticket(x,"Superman",4999);
        assertEquals("Superman",t1.getnombreFuncion());
        assertEquals(false, t1.validarPrecioMinimo(t1));
        LOG.info("Finalizando test validarPrecio");
    }
}
