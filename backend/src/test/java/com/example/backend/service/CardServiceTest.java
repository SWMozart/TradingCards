package com.example.backend.service;

import com.example.backend.model.Card;
import com.example.backend.repository.CardRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest

class CardServiceTest {

    CardRepo cardRepo = mock (CardRepo.class);

    CardService cardService = new CardService(cardRepo);

    @Test
    void addCard_ShouldReturn_AddedCard(){
        //GIVEN
        Card card = new Card("1","test","test1","test2","test3");
        when(cardRepo.save(any())).thenReturn(card);

        //WHEN
        Card actual = cardService.addCard(card);

        //THEN
         Card expected =new Card("1", "test", "test1", "test2", "test3");
        assertEquals(expected, actual);
    }

    @Test
    void getAllCard_ShouldReturn_AllCardInRepo(){
        // GIVEN
        Card card = new Card("1","test","test1","test2","test3");
        Card card2 = new Card("2","test2","test3","test4","test5");

        // speichern dummy cards in Repo
        cardRepo.save(card);
        cardRepo.save(card2);
        // Sag dem gemocketen Repo, dass die Liste von Card und Card2 zurückgegeben werden sollen.
        when(cardRepo.findAll()).thenReturn(List.of(card, card2));

        // WHEN
        List<Card> actual = cardService.getAllCards();

        // THEN
        List<Card> expected = List.of(card, card2);

        assertEquals(expected, actual);

    }

}