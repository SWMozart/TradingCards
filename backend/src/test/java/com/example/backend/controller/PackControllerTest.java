package com.example.backend.controller;

import com.example.backend.model.Card;
import com.example.backend.model.Pack;
import com.example.backend.repository.PackRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PackControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private  PackRepo packrepo;



    @Test
    void getAllPacks() throws Exception {
        //GIVEN
        Card dummyCard = new Card("1","test1","test2","test3","test4");
        Card dummyCard2 = new Card("2","test1","test2","test3","test4");
        Card dummyCard3 = new Card("3","test1","test2","test3","test4");


        Pack dummyPack = new Pack("1","Legend Player1","Pack1", List.of(dummyCard,dummyCard2,dummyCard3));
        packrepo.save(dummyPack);


        // WHEN & THEN

        String expectedJSON = """
            [
               {
                   "id": "1",
                   "category": "Legend Player1",
                   "name": "Pack1",
                   "cardsInAPack": [
                       {
                           "id": "1",
                           "name": "test1",
                           "position": "test2",
                           "category": "test3",
                           "poster": "test4"
                       },
                       {
                           "id": "2",
                           "name": "test1",
                           "position": "test2",
                           "category": "test3",
                           "poster": "test4"
                           },
                       {
                           "id": "3",
                           "name": "test1",
                           "position": "test2",
                           "category": "test3",
                           "poster": "test4"
                       }
                   ]
               }
               ]
                """;
        mockMvc.perform(get("/api/packs"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJSON));
    }



}