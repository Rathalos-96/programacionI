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

public class BibliotecaTest {
    private static final Logger LOG = Logger.getLogger(BibliotecaTest.class.getName());

    /**
     * Rigorous Test
     */
    @Test
    public void agregarPersona() 
    {
        LOG.info("Iniciado test agregarPersona");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Persona p1 = new Persona("1094957292","Joan","jsvelasquez@uqvirtual.edu.co","3502790733");

        b1.agregarPersona(p1);
        assertTrue(b1.getPersonas().contains(p1));
        assertEquals(1, b1.getPersonas().size());
        LOG.info("Finalizando test agregarPersona");
    }

    @Test
    public void buscarPerson() 
    {
        LOG.info("Iniciado test buscarPerson");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Persona p1 = new Persona("1094957292","Joan","jsvelasquez@uqvirtual.edu.co","3502790733");
        Persona p2 = new Persona("1094957293","Joan1","j1svelasquez@uqvirtual.edu.co","3502790733");

        b1.agregarPersona(p1);
        assertTrue(b1.getPersonas().contains(p1));
        assertEquals(1, b1.getPersonas().size());
        LOG.info("Finalizando test buscarPerson");
    }

    @Test
    public void agregarPersonaRepetido() {

        LOG.info("Iniciado test agregarPersonaRepetido");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Persona p1 = new Persona("1094957292","Joan","jsvelasquez@uqvirtual.edu.co","3502790733");
        Persona p2 = new Persona("1094957293","Joan1","j1svelasquez@uqvirtual.edu.co","3502790733");

        b1.agregarPersona(p1);
        b1.agregarPersona(p2);
        LOG.info("Finalizando test agregarPersonaRepetido");
    }

    @Test
    public void eliminarPersona() 
    {
        LOG.info("Iniciado test eliminarPersona");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Persona p1 = new Persona("1094957292","Joan","jsvelasquez@uqvirtual.edu.co","3502790733");
        Persona p2 = new Persona("1094957293","Joan1","j1svelasquez@uqvirtual.edu.co","3502790733");

        b1.agregarPersona(p1);
        b1.agregarPersona(p2);
        b1.eliminarPersona(p2);
        assertEquals(2, b1.getPersonas().size());
        LOG.info("Finalizando test eliminarPersona");
    }
    /////////////Recurso
    @Test
    public void agregarRecurso() 
    {
        LOG.info("Iniciado test agregarRecurso");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Recurso r1 = new Recurso("Teorema I", "0001", false,"libro");
        Recurso r2 = new Recurso("Info Java", "0002", false,"revista");
        Recurso r3 = new Recurso("Tomo 5", "0003", false,"medio audio visual");

        b1.agregarRecurso(r1);
        b1.agregarRecurso(r2);
        b1.agregarRecurso(r3);
        assertTrue(r1.getNombre().equals("Teorema I"));
        assertEquals(2, b1.getRecursosBiblioteca().size());
        LOG.info("Finalizando test agregarRecurso");
    }

    @Test
    public void buscarRecurso() 
    {
        LOG.info("Iniciado test buscarRecurso");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Recurso r1 = new Recurso("Teorema I", "0001", false,"libro");
        Recurso r2 = new Recurso("Info Java", "0002", false,"revista");
        Recurso r3 = new Recurso("Tomo 5", "0003", false,"medio audio visual");
        b1.agregarRecurso(r1);
        b1.agregarRecurso(r2);
        b1.agregarRecurso(r3);
        assertTrue(b1.buscarRecurso(r3).equals(r3));
        assertTrue(b1.getRecursosBiblioteca().contains(r3));
        assertEquals(2, b1.getRecursosBiblioteca().size());
        LOG.info("Finalizando test buscarRecurso");
    }

    //validar mejor recurso y person, con recurso validar ID tipo, ENCONSTRUCCION
    @Test
    public void agregarRecursoRepetido() {

        LOG.info("Iniciado test agregarPersonaRepetido");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Recurso r1 = new Recurso("Teorema I", "0001", false,"libro");
        Recurso r2 = new Recurso("Info Java", "0002", false,"revista");
        Recurso r3 = new Recurso("Teorema I", "0003", false,"medio audio visual");

        b1.agregarRecurso(r1);
        b1.agregarRecurso(r2);
        b1.agregarRecurso(r3);
        LOG.info("Finalizando test agregarPersonaRepetido");
    }

    @Test
    public void eliminarRecurso() 
    {
        LOG.info("Iniciado test eliminarPersona");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Recurso r1 = new Recurso("Teorema I", "0001", false,"libro");
        Recurso r2 = new Recurso("Info Java", "0002", false,"revista");
        Recurso r3 = new Recurso("Teorema II", "0003", false,"medio audio visual");

        b1.agregarRecurso(r1);
        b1.agregarRecurso(r2);
        b1.agregarRecurso(r3);

        b1.eliminarRecurso(r2);
        assertEquals(1, b1.getRecursosBiblioteca().size());
        LOG.info("Finalizando test eliminarPersona");
    }

    @Test
    public void validarEstadoActualRecurso()
    {
        LOG.info("Iniciado test validarEstadoActualRecurso");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Recurso r1 = new Recurso("Teorema I", "0001", false,"libro");
        Recurso r2 = new Recurso("Info Java", "0002", true,"revista");
        Recurso r3 = new Recurso("Teorema II", "0003", false,"medio audio visual");

        b1.agregarRecurso(r1);
        b1.agregarRecurso(r2);
        b1.agregarRecurso(r3);

        assertTrue(b1.validarEstadoActualizar(r2));
        LOG.info("Finalizando test validarEstadoActualRecurso");
    }

    @Test
    public void prestarRecursoApersona()
    {
        LOG.info("Iniciado test prestarRecursoApersona");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Recurso r1 = new Recurso("Teorema I", "0001", false,"libro");
        Recurso r2 = new Recurso("Info Java", "0002", false,"revista");
        Recurso r3 = new Recurso("Teorema II", "0003", false,"medio audio visual");
        Persona p1 = new Persona("1094957292","Joan","jsvelasquez@uqvirtual.edu.co","3502790733");
        Persona p2 = new Persona("1094957293","Joan","jsvelasquez@uqvirtual.edu.co","3502790733");
        b1.agregarRecurso(r1);
        b1.agregarRecurso(r2);
        b1.agregarRecurso(r3);
        b1.agregarPersona(p1);
        b1.agregarPersona(p2);

        b1.validarEstadoActualizar(r3);

        b1.prestarRecursoAPersona(r3, p2);
        b1.prestarRecursoAPersona(r3, p1);

        assertEquals(1,p2.getListaPrestamo().size());
        assertEquals(2,p1.getListaPrestamo().size());
        LOG.info("Finalizando test validarEstadoActualRecurso");
    }

    @Test
    public void devolerRecursoABiblioteca()
    {
        LOG.info("Iniciado test devolerRecursoABiblioteca");
        Biblioteca b1 = new Biblioteca("Biblioteca U");
        Recurso r1 = new Recurso("Teorema I", "0001", false,"libro");
        Recurso r2 = new Recurso("Info Java", "0002", false,"revista");
        Recurso r3 = new Recurso("Teorema II", "0003", false,"medio audio visual");
        Persona p1 = new Persona("1094957292","Joan","jsvelasquez@uqvirtual.edu.co","3502790733");
        b1.agregarRecurso(r1);
        b1.agregarRecurso(r2);
        b1.agregarRecurso(r3);
        b1.agregarPersona(p1);
        b1.prestarRecursoAPersona(r3, p1);
        b1.prestarRecursoAPersona(r1, p1);
        b1.prestarRecursoAPersona(r2, p1);

        b1.devolerRecursoABiblioteca(r3, p1);
        assertEquals(true,r3.getPrestado());
        LOG.info("Finalizando test devolerRecursoABiblioteca");
    }
}
