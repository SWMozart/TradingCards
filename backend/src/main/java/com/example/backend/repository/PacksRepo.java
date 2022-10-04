package com.example.backend.repository;

import com.example.backend.model.Card;
import com.example.backend.model.Pack;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class PacksRepo {

    // Hier sollten alle Karten angelegt werden.
    Map<String, Card> cardMap = new HashMap<>();

    // Hier sollte ein Paket angelegt werden.
    Map<String, Pack> packMap = new HashMap<>();

    // Hier sollten alle Pakete anegelegt werden.
    List<Map<String, Pack>> packList = new ArrayList<>();
}
