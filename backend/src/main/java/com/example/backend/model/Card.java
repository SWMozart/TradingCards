package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String id;

    private String name;
    private String position;
    private String category;
    private String poster;

    // TO-Do: statistic

}
