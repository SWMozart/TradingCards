package com.example.backend.repository;

import com.example.backend.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepo extends MongoRepository<Card, String> {

//    // Hier sollten alle Karten angelegt werden.
//    Map<String, Card> cardMap = new HashMap<>();
//
//    // Hier sollte ein Paket angelegt werden.
//    Map<String, Pack> packMap = new HashMap<>();
//
//    // Hier sollten alle Pakete anegelegt werden.
//    List<Map<String, Pack>> packList = new ArrayList<>();
}
