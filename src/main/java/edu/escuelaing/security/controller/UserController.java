package edu.escuelaing.security.controller;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.model.Zone;
import edu.escuelaing.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/user" )
public class UserController {


    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping
    public List<User> all()
    {
        return userService.all();
    }

    @GetMapping( "/{id}" )
    public User findById( @PathVariable String id )
    {
        return userService.findById( id );
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


    @GetMapping("/zone")
    public ResponseEntity<Zone> consultDangerZone(@RequestBody ZoneDto zoneDto){
        return ResponseEntity.ok(userService.consulteDanger(zoneDto));

    }

    @GetMapping("/verifyZone")
    public ResponseEntity<Integer> contStoleInZone(@RequestBody ZoneDto zoneDto){
        return ResponseEntity.ok(userService.verifyStoleZone(zoneDto));

    }

}
