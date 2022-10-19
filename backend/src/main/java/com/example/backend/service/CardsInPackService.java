package com.example.backend.service;

import com.example.backend.model.Card;
import com.example.backend.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CardsInPackService {
    private CardRepo cardRepo;

    @Autowired
    public CardsInPackService(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public List<Card> defineAPack() {
        List<Card> allCards = cardRepo.findAll();
        Random rand = new Random();

        // create a temporary list for storing
        // selected element
        List<Card> newList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            // take a random index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(allCards.size());

            // add element in temporary list
            newList.add(allCards.get(randomIndex));
        }
        return newList;
    }
}
