package co.edu.uniquindio.poo;

import java.sql.Date;
import java.time.LocalDateTime;

public class Ticket {
    
    private LocalDateTime fechaFuncion;
    private String nombreFuncion;
    private double valorBoleta;

    // Constructor
    //Validar si con LocalDateTime o con calendar
    public Ticket(LocalDateTime fechaFuncion, String nombreFuncion, double valorBoleta) {
        this.fechaFuncion = fechaFuncion;
        this.nombreFuncion = nombreFuncion;
        this.valorBoleta = valorBoleta;
        assert nombreFuncion != null;
        assert valorBoleta > 0;
    }

    // Getters
    public LocalDateTime getfechaFuncion() {
        return fechaFuncion;
    }

    public String getnombreFuncion() {
        return nombreFuncion;
    }

    public double getvalorBoleta() {
        return valorBoleta;
    }

    // Setters
    public void setfechaFuncion(LocalDateTime fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public void setnombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public void setvalorBoleta(double valorBoleta) {
        this.valorBoleta = valorBoleta;
    }

    @Override
    public String toString() {
        return "Ticket" + 
                "Hora de funcion=" + fechaFuncion +
                ", Nombre de la pelicula ='" + nombreFuncion + '\'' +
                ", total a pagar= " + valorBoleta;
    }

    public Boolean validarPrecioMinimo(Ticket t) {
        
        if (t.getvalorBoleta()>=5000) {
            return true;
        }
        return false; 
    }
}
