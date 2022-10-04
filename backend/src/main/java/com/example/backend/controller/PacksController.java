package com.example.backend.controller;

import com.example.backend.service.PacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/packs")
public class PacksController {

    private PacksService packsService;

    @Autowired
    public PacksController(PacksService packsService) {
        this.packsService = packsService;
    }



}
