package edu.escuelaing.security.service;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.exception.UserNotFoundException;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.model.Zone;

import java.util.List;

public interface UserService {

    User create(UserDto user );

    User findByCorreo( String correo )
            throws UserNotFoundException;

    Stole createStole(StoleDto stoleDto);

    Zone consulteDanger(ZoneDto zoneDto);

    int verifyStoleZone(ZoneDto zoneDto);

    List<User> all();

    User findById(String id);
}
