package co.edu.uniquindio.poo;

import java.lang.reflect.Member;
import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    
    private String nombre;
    private Collection<Recurso> recursosBiblioteca;
    private Collection<Persona> personas;

    public Biblioteca(String nombre){
        this.nombre = nombre;
        recursosBiblioteca = new LinkedList<Recurso>();
        personas = new LinkedList<Persona>();
        assert nombre != null;
    }

    //**************************************** Validaciones *******************************************************/
    public boolean validarIdExistent(String id)
    {
        for (Persona persona : personas) {
            if(persona.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public boolean validarNombreRecursoExistente(String nombre)
    {
        for (Recurso recurso : recursosBiblioteca) {
            if(recurso.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    //**************************************** Validaciones *******************************************************/ 
    //**************************************** METODOS ************************************************************/

    public void agregarPersona(Persona persona)
    {
        assert validarIdExistent(persona.getId())==false;
        personas.add(persona);
    }

    public void eliminarPersona(Persona persona)
    {
        if(validarIdExistent(persona.getId())==true){
            personas.remove(persona);
        }
        assert validarIdExistent(persona.getId())==false;
    }

    public Persona buscarPersona(Persona persona){
        if (validarIdExistent(persona.getId())==true) {
            return persona;
        }
        assert validarIdExistent(persona.getId())==false;
        return null;
    }

    public void agregarRecurso(Recurso recurso)
    {
        assert validarNombreRecursoExistente(recurso.getNombre())==false;
        recurso.setPrestado(false);
        recursosBiblioteca.add(recurso);
    }

    public void eliminarRecurso(Recurso recurso)
    {
        if(validarNombreRecursoExistente(recurso.getNombre())==true){
            recursosBiblioteca.remove(recurso);
        }
        assert validarNombreRecursoExistente(recurso.getNombre())==false;
    }

    public Recurso buscarRecurso(Recurso recurso){
        if (validarNombreRecursoExistente(recurso.getNombre())==true) {
            return recurso;
        }
        assert validarNombreRecursoExistente(recurso.getNombre())==false;
        return null;
    }

    public boolean validarEstadoActualizar(Recurso recurso)
    {
        var ejm = buscarRecurso(recurso);
        if (ejm!=null) {
            return ejm.getPrestado();
        }
        return ejm.getPrestado();
    }

    public boolean prestarRecursoAPersona(Recurso recurso,Persona persona)
    {   
        if (buscarRecurso(recurso)!=null && recurso.getPrestado()==false && buscarPersona(persona)!=null) {
            persona.agregarRecursoAPersona(persona, recurso);
            return true;
        }

        return false;
    }

    public boolean devolerRecursoABiblioteca(Recurso recurso,Persona persona)
    {   
        if (buscarRecurso(recurso)!=null && recurso.getPrestado()==true && buscarPersona(persona)!=null) {
            persona.devolerRecursoABiblioteca(persona, recurso);
            return false;
        }
        return false;
    }


    //**************************************** METODOS *******************************************************/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Recurso> getRecursosBiblioteca() {
        return recursosBiblioteca;
    }

    public void setRecursosBiblioteca(Collection<Recurso> recursosBiblioteca) {
        this.recursosBiblioteca = recursosBiblioteca;
    }

    public Collection<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Collection<Persona> personas) {
        this.personas = personas;
    }


}
