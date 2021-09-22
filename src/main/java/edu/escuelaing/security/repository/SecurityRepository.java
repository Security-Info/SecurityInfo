package edu.escuelaing.security.repository;

import edu.escuelaing.security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SecurityRepository extends MongoRepository<User, String> {

    Optional<User> findByCorreo( String correo);

}
