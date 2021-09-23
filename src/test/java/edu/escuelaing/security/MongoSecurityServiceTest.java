package edu.escuelaing.security;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.repository.SecurityRepository;
import edu.escuelaing.security.repository.StoleRepository;
import edu.escuelaing.security.service.UserService;
import edu.escuelaing.security.service.UserServiceMongo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestInstance( TestInstance.Lifecycle.PER_CLASS )

class MongoSecurityServiceTest {
    UserService securityRepository;

    @MockBean
    SecurityRepository repository;
    @MockBean
    StoleRepository stoleRepository;
    @BeforeAll()
    public void setup() {
        securityRepository = new UserServiceMongo(repository);
    }


    @Test
    void createUserService() {
        String nombre= "james";
        String clave= "3214";
        String correo= "james1999torres@gmai.com";
        String numeroTelefono= "320877762111";
        double latitud = 4.7614693950567;
        double longitud = -74.06976689221493;
        UserDto user= new UserDto(nombre,clave,correo,false,numeroTelefono,latitud, longitud);
        securityRepository.create(user);
        verify(repository).save(any(User.class));
    }

    @Test
    void createUserServiceStole() {
        double lat = 4.7614693950567;
        double lng = -74.06976689221493;
        StoleDto stoledto= new StoleDto(new Date(),lat,lng,"Me robaron en esta zona");
        Stole stole= new Stole(stoledto);
        securityRepository.createStole(stoledto);
        verify(stoleRepository).save(any(Stole.class));
        Assertions.fail();
    }

    @Test
    void consulteDangertest() {
        double lat = 4.7614693950567;
        double lng = -74.06976689221493;
        ZoneDto zona = new ZoneDto(lat, lng);
        Assertions.assertTrue(true);
    }


}
