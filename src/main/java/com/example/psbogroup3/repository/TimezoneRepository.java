package com.example.psbogroup3.repository;

import com.example.psbogroup3.entity.Timezone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alvinamaharani
 */
@Repository
public interface TimezoneRepository extends MongoRepository<Timezone, String> {

}
