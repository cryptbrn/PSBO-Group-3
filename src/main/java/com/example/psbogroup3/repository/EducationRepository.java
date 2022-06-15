package com.example.psbogroup3.repository;

import com.example.psbogroup3.entity.Education;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LINZ_IS_HERE
 */
@Repository
public interface EducationRepository extends MongoRepository<Education, String> {

}
