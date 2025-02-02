package com.example.backend.model;

import com.example.backend.repository.CardRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("packs")
public class Pack {
    @Id
    private String id;
    private String category;
    private String name;
    private List<Card> cardsInAPack;

}
