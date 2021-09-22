package edu.escuelaing.security.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "securityInfo/health" )
public class HealthController
{

    @GetMapping
    public String all()
    {
        return "API Working OK!";
    }
}