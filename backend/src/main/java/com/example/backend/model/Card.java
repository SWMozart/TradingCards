package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("cards")
public class Card {
    @Id
    private String id;

    private String name;
    private String position;
    private String category;
    private String poster;

    private String year;
    private String height;
    private String weight;

}
