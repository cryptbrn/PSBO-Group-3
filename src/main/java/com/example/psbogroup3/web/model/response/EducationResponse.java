package com.example.psbogroup3.web.model.response;

import com.example.psbogroup3.enums.FinalScoreType;
import com.example.psbogroup3.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Linz_IS_HERE
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EducationResponse {
    private String id;
    
    private Level level;

    private String institution;

    private FinalScoreType finalScoreType;

    private Double finalScore;
}
