package com.example.backend.repository;

import com.example.backend.model.Pack;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackRepo extends MongoRepository<Pack, String> {


}
