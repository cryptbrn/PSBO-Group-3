package com.example.psbogroup3.repository;

import com.example.psbogroup3.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author muhammad.reyhan
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}
