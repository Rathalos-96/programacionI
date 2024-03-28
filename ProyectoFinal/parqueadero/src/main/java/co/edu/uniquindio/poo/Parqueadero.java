package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.LinkedList;


public class Parqueadero {

    private int tamanoParqueadero;
    private int tarifaCarro;
    private int tarifaMoto;
    private Registro matrizParqueadero[][];
    private Collection<Vehiculo> vehiculos;
    private Collection<Propietario> propietarios;
    private Collection<Registro> registros;

    public Parqueadero(int tamanoParqueadero, int tarifaCarro, int tarifaMoto) {
        this.tamanoParqueadero = tamanoParqueadero;
        this.tarifaCarro = tarifaCarro;
        this.tarifaMoto = tarifaMoto;
        vehiculos = new LinkedList<Vehiculo>();
        propietarios = new LinkedList<Propietario>();
        registros = new LinkedList<Registro>();
        matrizParqueadero = new Registro[tamanoParqueadero][tamanoParqueadero];
    }

    public int getTamanoParqueadero() {
        return tamanoParqueadero;
    }

    public void setTamanoParqueadero(int tamanoParqueadero) {
        this.tamanoParqueadero = tamanoParqueadero;
    }

    public int getTarifaCarro() {
        return tarifaCarro;
    }

    public void setTarifaCarro(int tarifaCarro) {
        this.tarifaCarro = tarifaCarro;
    }

    public int getTarifaMoto() {
        return tarifaMoto;
    }

    public void setTarifaMoto(int tarifaMoto) {
        this.tarifaMoto = tarifaMoto;
    }

    public Registro[][] getMatrizParqueadero() {
        return matrizParqueadero;
    }

    public void setMatrizParqueadero(Registro[][] matrizParqueadero) {
        this.matrizParqueadero = matrizParqueadero;
    }

    public Collection<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Collection<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Collection<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(Collection<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public Collection<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }
//////////////////////////////////////// ***Metodos de validacion****////////////////////////////////////////////////////////
    public boolean validarIdentificacionExistente(String identificacion)
    {
        for (Propietario propietario : propietarios) {
            if (propietario.getCedula().equalsIgnoreCase(identificacion)) {
                return true;
            }
        }
        return false;
    }
    public boolean validarPlacaExistente(String placa)
    {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }
    public Registro validarRegistroExistente(String placa)
    {
        for (Registro registro : registros) {
            if (registro.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return registro;
            }
        }
        return null;
    }
    public String validarRegistroPorUbicacion(int x,int y){
        if(matrizParqueadero[x][y]!=null)
        {
            Registro registro =  matrizParqueadero[x][y];
            return registro.getVehiculo().getPlaca();
        }
        return null;
    }
    ///////////////////////////////////Agregar/////////////////////////////////////////////////////////////
    public void agregarPropietario(Propietario p) {
        assert validarIdentificacionExistente(p.getCedula())==false;
        propietarios.add(p);
    }
    public void agregarVehiculo(Vehiculo v) {
        assert validarPlacaExistente(v.getPlaca())==false;
        vehiculos.add(v);

    }  
    public void agregarParqueo(Vehiculo v, int tarifa){
        assert validarPlacaExistente(v.getPlaca())==true; 
        agregarVehiculoAlParqueadero(v,tarifa);
    }
////////////////////////////////////////////****Matriz****///////////////////////////////////////////////////////////
    public void agregarVehiculoAlParqueadero(Vehiculo v,int tarifa){
        
        for (int i = 0; i < matrizParqueadero.length; i++) {
            for (int j = 0; j < matrizParqueadero.length; j++) {
                if (matrizParqueadero[i][j] == null) {
                    if(v.getIsParqueado()==false){
                        Registro r = new Registro(v.getPropietario(),v);
                        r.setFechaIngreso(LocalDateTime.now());
                        r.setTarifa(tarifa);
                        matrizParqueadero[i][j] = r;
                        r.getVehiculo().setIsParqueado(true);
                        registros.add(r);
                    }
                }
            }
            System.err.println("No hay mas puestos libres en el parqueadero.");
        }
    }
    public Boolean eliminarVehiculoAlParqueadero(Vehiculo v){
        for (int i = 0; i < matrizParqueadero.length; i++) {
            for (int j = 0; j < matrizParqueadero.length; j++) {
                    if(matrizParqueadero[i][j].getVehiculo().getPlaca().equals(v.getPlaca()))
                    {
                        Registro r = validarRegistroExistente(v.getPlaca());
                        if(r!=null)
                        {
                            long diffInMinutes = ChronoUnit.MINUTES.between(r.getFechaIngreso(),LocalDateTime.now());
                            r.setTotalPagar(r.getTarifa() * diffInMinutes);
                            r.getVehiculo().setIsParqueado(false);
                            r.setFechaFinal(LocalDateTime.now());
                            matrizParqueadero[i][j] = null;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    public Boolean buscarVehiculoAlParqueadero(String placa){
        Boolean bandera = false;
        for (int i = 0; i < matrizParqueadero.length; i++) {
            for (int j = 0; j < matrizParqueadero.length; j++) {
                if (matrizParqueadero[i][j].getVehiculo().getPlaca().equals(placa)) {
                    bandera = true;
                    return bandera;
                }
            }
        }
        return bandera;
    }
////////////////////////////////////////////****Registros masivos****///////////////////////////////////////////////////////////
    public LinkedList<Registro> generarRegistroDiario(String fecha1)
    {
        LinkedList<Registro> registroReporte = new LinkedList<Registro>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime inicio = LocalDateTime.parse(fecha1, formatter);

        for (Registro registro : registros) 
        {
            if (registro.getFechaIngreso().isBefore(LocalDateTime.now())&&registro.getFechaIngreso().isAfter(inicio)) {
                registroReporte.add(registro);
            }
        }
        return registroReporte;
    }
}


