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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
    public Stole createStole(StoleDto stoleDto) throws MessagingException {
        verifyUserZoneStole(stoleDto);
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
    public void verifyUserZoneStole(StoleDto stoleDto) throws MessagingException {
        double latRobo = stoleDto.getLatitud();
        double longRobo = stoleDto.getLongitud();
        List<User> usuarios = securityRepository.findAll();
        for(int i=0; i<usuarios.size(); i++){
            User usuario = usuarios.get(i);
            double usuarioLat = usuario.getLatitud();
            double usuarioLong = usuario.getLongitud();
            Zone zona = new Zone(usuarioLat,usuarioLong);
            if(zona.verifyStoleZone(latRobo,longRobo)){
                sendAlert(usuario.getCorreo(),stoleDto.getDescripcion(),latRobo,longRobo);
            }
        }
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

    public void sendAlert(String email,String descripcion, double lat, double longi) throws MessagingException {
        String remitente = "securtiyinfo98@gmail.com";
        String clave = "SecurtiyInfo98ieti.";
        String destino = email;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            message.setSubject("Alerta de seguridad en tu zona");
            message.setText("Ha ocurrido un reporte reciente de seguridad en tu zona, la descipcion es: "+descripcion+". el lugar exacto es: "+String.valueOf(lat)+String.valueOf(longi));
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }

    }

}

