package edu.escuelaing.security.dto;

import java.util.Date;

public class ZoneDto{
    private String nivel;
    private String rango;
    private Double cantReportes;

    public String getNivel() {
        return nivel;
    }
    public String getRango() {
        return rango;
    }
    public Double getReportes() {
        return cantReportes;
    }

    public void setDescripcion(String nivel) {
        this.nivel = nivel;
    }
    public void seRango(String rango) {
        this.rango = rango;
    }

    public void setHora(Double cantReportes) {
        this.cantReportes = cantReportes;
    }
}
