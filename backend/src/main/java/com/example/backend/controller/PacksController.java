package com.example.backend.controller;

import com.example.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/packs")
public class PacksController {

    private CardService cardService;

    @Autowired
    public PacksController(CardService cardService) {
        this.cardService = cardService;
    }



}
