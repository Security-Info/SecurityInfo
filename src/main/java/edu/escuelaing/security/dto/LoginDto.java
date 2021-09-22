package edu.escuelaing.security.dto;

public class LoginDto
{

    public String clave;
    public String correo;


    public LoginDto( String correo, String clave )
    {
        this.correo = correo;
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
