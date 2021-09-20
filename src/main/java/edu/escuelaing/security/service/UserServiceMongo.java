package edu.escuelaing.security.service;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.repository.SecurityRepository;
import edu.escuelaing.security.repository.StoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMongo implements UserService {

    private final SecurityRepository securityRepository;

    @Autowired
    private StoleRepository stoleRepository;

    public UserServiceMongo( @Autowired SecurityRepository securityRepository )
    {
        this.securityRepository = securityRepository;
    }

    @Override
    public User create(UserDto userDto) {
        return securityRepository.save(new User(userDto));
    }

    @Override
    public Stole createStole(StoleDto stoleDto) {
        return stoleRepository.save(new Stole(stoleDto));
    }

}
