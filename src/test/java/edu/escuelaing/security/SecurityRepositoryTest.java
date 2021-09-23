package edu.escuelaing.security;

import edu.escuelaing.security.dto.LoginDto;
import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.repository.SecurityRepository;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class SecurityRepositoryTest {

    @MockBean
    private SecurityRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage()
            throws Exception {
        assertThat(
                this.restTemplate.getForObject("http://localhost:" + port + "/securityInfo/health", String.class)).contains(
                "API Working OK!");
    }

    @Test
    public void greetingShouldReturnUser()
            throws Exception {
        double lat = 4.7614693950567;
        double lng = -74.06976689221493;
        StoleDto stoledto= new StoleDto(new Date(),lat,lng,"Me robaron en esta zona");

        assertThat(
                this.restTemplate.postForEntity("http://localhost:" + port + "/user/verifyZone", stoledto,StoleDto.class));
    }

    @Test
    public void greetingShouldReturnVerifyZone()
            throws Exception {
        double lat = 4.7614693950567;
        double lng = -74.06976689221493;
        ZoneDto zona = new ZoneDto(lat, lng);
        assertThat(

                this.restTemplate.postForEntity("http://localhost:" + port + "/user/verifyZone",zona,String.class));
    }

    @Test
    public void LoginUserTest()
            throws Exception {

        String clave = "326410";
        String correo = "felipecubillos010@gmail.com";
        LoginDto login= new LoginDto(correo,clave);

        assertThat(
                this.restTemplate.postForEntity("http://localhost:" + port + "/securityInfo/auth/user", login,LoginDto.class));
    }



}


