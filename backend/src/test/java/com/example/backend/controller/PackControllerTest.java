package com.example.backend.controller;

import com.example.backend.model.Card;
import com.example.backend.model.Pack;
import com.example.backend.repository.PackRepo;
import com.example.backend.service.CardsInPackService;
import com.example.backend.service.IdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PackControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private  PackRepo packrepo;
    @MockBean
    private IdService idService;
    @MockBean
    private CardsInPackService cardsInPackService;



    @Test
    void getAllPacks_ShouldReturn_AllPacksInRepo() throws Exception {
        //GIVEN
        Card dummyCard = new Card("1","test1","test2","test3","test4","test5","test6","test7");
        Card dummyCard2 = new Card("2","test1","test2","test3","test4","test5","test6","test7");
        Card dummyCard3 = new Card("3","test1","test2","test3","test4","test5","test6","test7");


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
                           "poster": "test4",
                           "year": "test5",
                           "height": "test6",
                           "weight": "test7"
                       },
                       {
                           "id": "2",
                           "name": "test1",
                           "position": "test2",
                           "category": "test3",
                           "poster": "test4",
                           "year": "test5",
                           "height": "test6",
                           "weight": "test7"
                           },
                       {
                           "id": "3",
                           "name": "test1",
                           "position": "test2",
                           "category": "test3",
                           "poster": "test4",
                           "year": "test5",
                           "height": "test6",
                           "weight": "test7"
                       }
                   ]
               }
               ]
                """;
        mockMvc.perform(get("/api/packs"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJSON));

    }

    @Test
    void addANewPack_ShouldReturn_AddedPack() throws Exception {
        // GIVEN
        when(idService.generateId()).thenReturn("1");
        when(cardsInPackService.defineAPack()).thenReturn(
                List.of(new Card("1","test1","test2","test3",
                        "test4","test5","test6","test7")));
        String requestBody = """
                {
                "category": "test1",
                "name": "test1",
                "cardsInAPack":[]
                }
        """;

        String expectedBody = """
                {
                "id": "1",
                "category": "test1",
                "name": "test1",
                "cardsInAPack":[
                    {
                           "id": "1",
                           "name": "test1",
                           "position": "test2",
                           "category": "test3",
                           "poster": "test4",
                           "year": "test5",
                           "height": "test6",
                           "weight": "test7"
                       }
                   ]
                }
        """;

        mockMvc.perform(
                        post("/api/packs")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedBody));
    }


}