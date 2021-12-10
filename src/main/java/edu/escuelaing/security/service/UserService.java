package edu.escuelaing.security.service;


import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.exception.UserNotFoundException;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.model.Zone;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

public interface UserService {

    User create(UserDto user );

    Stole createStole(StoleDto stoleDto) throws MessagingException;

    Zone consulteDanger(ZoneDto zoneDto);

    int verifyStoleZone(ZoneDto zoneDto);

    List<User> userAll();

    boolean deleteById(String id);

    User findByCorreo( String correo )
            throws UserNotFoundException;
    
    ArrayList<ArrayList<Double>> getZonesStoles(ZoneDto zoneDto);
    List<Stole> allStole();


}
