package edu.escuelaing.security.repository;


import edu.escuelaing.security.model.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZoneRepository extends MongoRepository<Zone, String> {


}