package com.example.backend.service;

import com.example.backend.model.Pack;
import com.example.backend.model.PackDTO;
import com.example.backend.repository.PackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackService {

    private PackRepo packRepo;

    private IdService idService;
    private CardsInPackService cardsInPackService;

    @Autowired
    public PackService(PackRepo packRepo, IdService idService, CardsInPackService cardsInPackService) {
        this.packRepo = packRepo;
        this.idService=idService;
        this.cardsInPackService = cardsInPackService;
    }


    public List<Pack> getAllPacks() {
        List<Pack> packs = packRepo.findAll();

//        for (Pack pack:packs){
//            pack.setCardsInAPack(defineAPack());
//        }
        return packs;
    }

    public Pack addANewPack(PackDTO packDto) {
        Pack newPack = Pack.builder()
                        .id(idService.generateId())
                        .category(packDto.getCategory())
                        .name(packDto.getName())
                        .cardsInAPack(cardsInPackService.defineAPack())
                        .build();
        return packRepo.save(newPack);
    }




    public void deleteAPack(String id) {
        packRepo.deleteById(id);
    }
}
