package edu.escuelaing.security.service;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.exception.UserNotFoundException;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.model.Zone;
import edu.escuelaing.security.repository.SecurityRepository;
import edu.escuelaing.security.repository.StoleRepository;
import edu.escuelaing.security.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceMongo implements UserService {

    private final SecurityRepository securityRepository;


    private StoleRepository stoleRepository;


    private ZoneRepository zoneRepository;

    public UserServiceMongo( @Autowired SecurityRepository securityRepository )
    {
        this.securityRepository = securityRepository;
    }

    @Override
    public User create(UserDto userDto) {
        return securityRepository.save(new User(userDto));
    }

    @Override
    public User findByCorreo( String correo )
            throws UserNotFoundException
    {
        Optional<User> optionalUser = securityRepository.findByCorreo(correo);
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public Stole createStole(StoleDto stoleDto) {
        return stoleRepository.save(new Stole(stoleDto));
    }

    @Override
    public Zone consulteDanger(ZoneDto zoneDto) {
        return zoneRepository.save(new Zone(zoneDto));
    }

    @Override
    public int verifyStoleZone(ZoneDto zoneDto) {
        return 0;
    }


}
