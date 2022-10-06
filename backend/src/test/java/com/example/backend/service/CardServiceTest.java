package com.example.backend.service;

import com.example.backend.model.Card;
import com.example.backend.repository.CardRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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

}