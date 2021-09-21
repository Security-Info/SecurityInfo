package edu.escuelaing.security.repository;

import edu.escuelaing.security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecurityRepository extends MongoRepository<User, String> {
}
