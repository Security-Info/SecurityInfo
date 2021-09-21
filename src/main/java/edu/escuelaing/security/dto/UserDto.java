package edu.escuelaing.security.dto;

public class UserDto {

    private String nombre;
    private String clave;
    private String correo;
    private boolean premium;
    private String numeroTelefono;

    public String getCorreo() {
        return correo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
