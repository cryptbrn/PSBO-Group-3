package com.example.psbogroup3.entity;

import com.example.psbogroup3.enums.FinalScoreType;
import com.example.psbogroup3.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* Linz_IS_HERE */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("education")

public class Education {
    @Id
    private String id;
    
    private Level level;

    private String institution;

    private FinalScoreType finalScoreType;

    private Double finalScore;
}
