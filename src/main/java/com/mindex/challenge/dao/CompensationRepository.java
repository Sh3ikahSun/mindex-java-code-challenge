package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    //Compensation findByEmployeeId(String employeeId);
}


/** I am unsure how to implement this. I haven't been able to find the similar implementation of the
 * employee repository to use as a guide. I was thinking I might have to create a "compensation_database.json"
 * file, and implement insert, put, post, and findByEmployeeId into a new class that implements this
 * one.
 * I haven't actually used Spring before, but I've learned a lot from this challenge, so thank you. :)
 */
