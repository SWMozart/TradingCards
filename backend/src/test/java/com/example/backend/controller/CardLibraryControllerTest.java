package com.example.backend.controller;

import com.example.backend.model.Card;
import com.example.backend.repository.CardRepo;
import com.example.backend.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CardLibraryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CardRepo cardRepo;

    @Test
    void addCard() throws Exception {
        // String
        String requestBody = """
                {
                "id": "1",
                "name": "Steve Nash",
                "position": "PG",
                "category":"Basketball",
                "poster":"testimage.com"
                }
        """;

        String expectedJSON = """
                {
                "id": "1",
                "name": "Steve Nash",
                "position": "PG",
                "category":"Basketball",
                "poster":"testimage.com"
                }
        """;

        // WHEN THEN
        mockMvc.perform(
                post("/api/cards")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));

    }

    @Test
    void getAllCards() throws Exception {
        // GIVEN
        Card card = new Card("1","test","test1","test2","test3", "test4","test5","test6");
        Card card2 = new Card("2","test2","test3","test4","test5", "test4","test5","test6");

        // speichern dummy cards in Repo
        cardRepo.save(card);
        cardRepo.save(card2);

        String expectedJSON = """
            [
                {
                "id": "1",
                "name": "test",
                "position": "test1",
                "category":"test2",
                "poster":"test3",
                "year":"test4",
                "height":"test5",
                "weight":"test6"
                },
                {
                "id": "2",
                "name": "test2",
                "position": "test3",
                "category":"test4",
                "poster":"test5",
                "year":"test4",
                "height":"test5",
                "weight":"test6"
                }
            ]
        """;

        // WHEN THEN
        mockMvc.perform(
                get("/api/cards"))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedJSON));
    }
}