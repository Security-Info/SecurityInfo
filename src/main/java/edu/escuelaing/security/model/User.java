package edu.escuelaing.security.model;

import edu.escuelaing.security.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class User {

    @Id
    private String id;
    private String nombre;
    private String correo;
    private String clave;
    private boolean premium;
    private String numeroTelefono;

    public User(UserDto userDto) {

        nombre = userDto.getNombre();
        correo = userDto.getCorreo();
        clave = userDto.getClave();
        premium = userDto.isPremium();
        numeroTelefono = userDto.getNumeroTelefono();

    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public boolean isPremium() {
        return premium;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
