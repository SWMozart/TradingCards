package com.example.backend.service;

import com.example.backend.model.Card;
import com.example.backend.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private CardRepo cardRepo;
    @Autowired
    public CardService(CardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public Card addCard(Card card){
        return cardRepo.save(card);
    }

    public List<Card> getAllCards(){
        return cardRepo.findAll();
    }
}
