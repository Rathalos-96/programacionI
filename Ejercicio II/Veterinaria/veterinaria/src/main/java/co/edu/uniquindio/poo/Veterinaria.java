package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Veterinaria {
    
    private String nombre;
    private Collection<Mascota> mascotas;

    public Veterinaria(String nombre) {
        this.nombre = nombre;
        mascotas = new LinkedList<Mascota>();
        assert nombre != null;
    }

    public void agregarMascotas(Mascota mascota)
    {   
        assert validarIdentificacionDuenoExistente(mascota.getIdenificacionDueno())==false;
        mascotas.add(mascota);
    }
    public boolean validarIdentificacionDuenoExistente(String identificacionDueno)
    {
        for (Mascota mascota : mascotas) {
            if (mascota.getIdenificacionDueno().equalsIgnoreCase(identificacionDueno)) {
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Collection<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    

}
