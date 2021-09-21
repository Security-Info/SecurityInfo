package edu.escuelaing.security.service;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.model.Zone;

public interface UserService {

    User create(UserDto user );

    Stole createStole(StoleDto stoleDto);

    Zone consulteDanger(ZoneDto zoneDto);

    int verifyStoleZone(ZoneDto zoneDto);

}
