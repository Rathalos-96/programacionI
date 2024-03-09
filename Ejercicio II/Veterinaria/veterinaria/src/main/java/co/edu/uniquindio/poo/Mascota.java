package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Mascota
    {
        private String nombre,especie, raza, genero, color,idenificacionDueno;
        private int edad,peso;

    public Mascota(String nombre, String especie,String raza, String genero,String color,String identificacionDueno,int edad,int peso) {
        this.nombre = nombre;
        LinkedList<Mascota> mascotas = new LinkedList<Mascota>();
        assert nombre != null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIdenificacionDueno() {
        return idenificacionDueno;
    }

    public void setIdenificacionDueno(String idenificacionDueno) {
        this.idenificacionDueno = idenificacionDueno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    
}