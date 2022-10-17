package com.example.backend.service;

import com.example.backend.model.Card;
import com.example.backend.model.Pack;
import com.example.backend.repository.CardRepo;
import com.example.backend.repository.PackRepo;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class PackServiceTest {

   private final PackRepo repo =mock(PackRepo.class);

    private final IdService idService = mock(IdService.class);
    private final CardRepo cardRepo = mock (CardRepo.class);

    private final PackService service = new PackService(repo, cardRepo, idService);

    @Test
    void getAllPacks() {
      //GIVEN

        Card dummyCard = new Card("1","test1","test2","test3","test4","test5","test6","test7");
        Card dummyCard2 = new Card("2","test1","test2","test3","test4","test2","test3","test4");
        Card dummyCard3 = new Card("3","test1","test2","test3","test4","test2","test3","test4");

        Pack pack = new Pack("1","Legend Player1","Pack1", List.of(dummyCard,dummyCard2,dummyCard3));
        when(idService.generateId()).thenReturn("1");

        when(repo.findAll())
                .thenReturn(List.of(pack));

        //WHEN
        List<Pack> actual = service.getAllPacks();

        //Then
        List<Pack> expected = List.of(pack);
        assertEquals(expected, actual);
    }



}