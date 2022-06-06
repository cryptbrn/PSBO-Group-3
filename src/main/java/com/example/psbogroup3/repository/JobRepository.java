package com.example.psbogroup3.repository;

import com.example.psbogroup3.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {

}
