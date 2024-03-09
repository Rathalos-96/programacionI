package co.edu.uniquindio.poo;

public class Recurso {

    private String nombre;
    private String prestadoId;
    private Boolean prestado;
    private String tipoRecurso;

    public Recurso(String nombre, String prestadoId, Boolean prestado,String tipoRecurso) {
        this.nombre = nombre;
        this.prestadoId = prestadoId;
        this.prestado = prestado;
        this.tipoRecurso = tipoRecurso;
        assert nombre != null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrestadoId() {
        return prestadoId;
    }

    public void setPrestadoId(String prestadoId) {
        this.prestadoId = prestadoId;
    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }
}
