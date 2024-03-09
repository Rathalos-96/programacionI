package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Persona {

    private String id;
    private String nombre;
    private String correo;
    private String telefono;
    private Collection<Recurso> listaPrestamo;

    public Persona(String id, String nombre, String correo, String telefono)
    {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        listaPrestamo = new LinkedList<Recurso>();
        assert nombre != null;
    }

    //**************************************** METODOS *******************************************************/


    //**************************************** METODOS *******************************************************/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<Recurso> getListaPrestamo() {
        return listaPrestamo;
    }

    public void setListaPrestamo(Collection<Recurso> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }   
}
