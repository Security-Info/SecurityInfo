package edu.escuelaing.security.controller.AuthController;

import edu.escuelaing.security.dto.LoginDto;
import edu.escuelaing.security.dto.TokenDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import  edu.escuelaing.security.service.UserService;
import edu.escuelaing.security.exception.InvalidCredentialsException;
import edu.escuelaing.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.Calendar;
import java.util.Date;

import  static edu.escuelaing.security.utils.Constants.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping( "securityInfo/auth" )
public class AuthController
{

    @Value( "${app.secret}" )
    String secret;

    private final UserService userService;

    public AuthController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

  @PostMapping("/user")
   public TokenDto login(@RequestBody LoginDto loginDto )
  {
    User user = userService.findByCorreo( loginDto.correo );
    if ( BCrypt.checkpw( loginDto.clave, user.getClave() ) )
        {
         return generateTokenDto( user );
        }
        else
        {
            throw new InvalidCredentialsException();
        }

    }

    private String generateToken( User user, Date expirationDate )
    {
        return Jwts.builder()
                .setSubject( user.getId() )
                .claim( CLAIMS_ROLES_KEY, user.getRoles() )
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, secret )
                .compact();
    }

    private TokenDto generateTokenDto( User user )
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken( user, expirationDate.getTime() );
        return new TokenDto( token, expirationDate.getTime() );
    }
}
