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

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/user" )
@CrossOrigin("*")
public class UserController {


    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> all()
    {
        return ResponseEntity.ok( userService.userAll() );
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto )
    {
        return ResponseEntity.ok( userService.create( userDto ) );
    }


    @PostMapping("/stole")
    public ResponseEntity<Stole> createStole(@RequestBody StoleDto stoleDto ) throws MessagingException {
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
    
    @GetMapping("/getZones")
    public ResponseEntity<ArrayList<ArrayList<Double>>> getZones(@RequestBody ZoneDto zoneDto){
        return ResponseEntity.ok(userService.getZonesStoles(zoneDto));

    }
    
    @GetMapping("/allStole")
    public ResponseEntity<List<Stole>> allStole()
    {
        return ResponseEntity.ok( userService.allStole() );
    }

}
