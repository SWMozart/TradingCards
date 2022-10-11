package com.example.backend.controller;

import com.example.backend.model.Pack;
import com.example.backend.model.PackDTO;
import com.example.backend.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packs")
public class PackController {

    private PackService packService;

    @Autowired
    public PackController(PackService packService) {
        this.packService = packService;
    }

    @GetMapping
    public List<Pack> getAllPacks(){
        return packService.getAllPacks();
    }

    @PostMapping
    public Pack addANewPack(@RequestBody PackDTO packDto){
        return packService.addANewPack(packDto);
    }

    @DeleteMapping("{id}")
    public void deleteAPack(@PathVariable String id){
        packService.deleteAPack(id);
    }


}
