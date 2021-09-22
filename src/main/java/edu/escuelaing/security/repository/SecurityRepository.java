package edu.escuelaing.security.repository;
import edu.escuelaing.security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SecurityRepository extends MongoRepository<User, String> {

}




