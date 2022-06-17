package com.example.psbogroup3.repository;

import com.example.psbogroup3.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author muhammad.reyhan
 */
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

}
