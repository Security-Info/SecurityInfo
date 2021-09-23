package edu.escuelaing.security.dto;

import java.util.Date;

public class StoleDto {
    private Date fecha;
    private double latitud;
    private double longitud;
    private String descripcion;

    public StoleDto(Date fecha, double latitud, double longitud, String descripcion) {
        this.fecha = fecha;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }


    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
