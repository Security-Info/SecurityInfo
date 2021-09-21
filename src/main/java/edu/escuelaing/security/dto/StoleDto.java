package edu.escuelaing.security.dto;

import java.util.Date;

public class StoleDto {
    private Date fecha;
    private String hora;
    private String zona;
    private String descripcion;


    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getZona() {
        return zona;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
