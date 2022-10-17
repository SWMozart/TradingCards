package com.example.backend.service;

import com.example.backend.model.Card;
import com.example.backend.model.Pack;
import com.example.backend.model.PackDTO;
import com.example.backend.repository.CardRepo;
import com.example.backend.repository.PackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PackService {

    private PackRepo packRepo;
    private CardRepo cardRepo;
    private IdService idService;

    @Autowired
    public PackService(PackRepo packRepo, CardRepo cardRepo, IdService idService) {
        this.packRepo = packRepo;
        this.cardRepo = cardRepo;
        this.idService=idService;
    }


    public List<Pack> getAllPacks() {
        List<Pack> packs = packRepo.findAll();

        for (Pack pack:packs){
            pack.setCardsInAPack(defineAPack());
        }
        return packs;
    }

    public Pack addANewPack(PackDTO packDto) {
        Pack newPack = Pack.builder()
                        .id(idService.generateId())
                        .category(packDto.getCategory())
                        .name(packDto.getName())
                        .cardsInAPack(defineAPack())
                        .build();
        return packRepo.save(newPack);
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

    public void deleteAPack(String id) {
        packRepo.deleteById(id);
    }
}
