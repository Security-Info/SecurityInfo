package edu.escuelaing.security.model;


import edu.escuelaing.security.dto.StoleDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Stole{
    @Id
    private String id;
    private Date fecha;
    private double latitud;
    private double longitud;
    private String descripcion;

    public Stole() {
    }

    public Stole(StoleDto stoleDto) {
        fecha = stoleDto.getFecha();
        latitud = stoleDto.getLatitud();
        longitud = stoleDto.getLongitud();
        descripcion = stoleDto.getDescripcion();
    }

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
