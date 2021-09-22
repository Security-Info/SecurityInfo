package edu.escuelaing.security.service;

import edu.escuelaing.security.dto.StoleDto;
import edu.escuelaing.security.dto.UserDto;
import edu.escuelaing.security.dto.ZoneDto;
import edu.escuelaing.security.model.Stole;
import edu.escuelaing.security.model.User;
import edu.escuelaing.security.model.Zone;
import edu.escuelaing.security.repository.SecurityRepository;
import edu.escuelaing.security.repository.StoleRepository;
import edu.escuelaing.security.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongo implements UserService {

    private final SecurityRepository securityRepository;

    @Autowired
    private StoleRepository stoleRepository;

    @Autowired
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
    public Stole createStole(StoleDto stoleDto) {
        return stoleRepository.save(new Stole(stoleDto));
    }

    @Override
    public Zone consulteDanger(ZoneDto zoneDto) {
        return zoneRepository.save(new Zone(zoneDto));
    }

    @Override
    public int verifyStoleZone(ZoneDto zoneDto) {
        int contador = 0;
        double lat = zoneDto.getLatitud();
        double lang = zoneDto.getLongitud();
        Zone zona = new Zone(zoneDto);

        List<Stole> robos = stoleRepository.findAll();

        for(int i=0; i<robos.size(); i++){
            Stole indexRobo = robos.get(i);
            double latRobo = indexRobo.getLatitud();
            double logRobo = indexRobo.getLongitud();
            if(zona.verifyStoleZone(latRobo,logRobo)){
                contador++;
            }


        }
        return contador;






    }

    @Override
    public List<User> userAll() {
        return securityRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {

        if(stoleRepository.existsById(id)){
            stoleRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
