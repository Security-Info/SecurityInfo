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
}
