package edu.escuelaing.security.controller;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/user" )
public class UserController {


    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( userDto ) );
    }


    @PostMapping("/stole")
    public ResponseEntity<Stole> createStole(@RequestBody StoleDto stoleDto )
    {
        return ResponseEntity.ok( userService.createStole( stoleDto ) );
    }
    
    

}
