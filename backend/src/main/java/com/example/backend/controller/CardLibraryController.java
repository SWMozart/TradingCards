package com.example.backend.controller;

import com.example.backend.model.Card;
import com.example.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cards")
public class CardLibraryController {
    private CardService cardService;

    @Autowired
    public CardLibraryController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public Card addCard(@RequestBody Card card){
        return cardService.addCard(card);
    }

    @GetMapping
    public List<Card> getAllCards (){
        return cardService.getAllCards();
    }
}
