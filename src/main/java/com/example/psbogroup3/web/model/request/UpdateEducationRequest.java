package com.example.psbogroup3.web.model.request;

import com.example.psbogroup3.enums.FinalScoreType;
import com.example.psbogroup3.enums.Level;
import com.example.psbogroup3.validation.StringEnumeration;
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
public class UpdateEducationRequest {
  //@StringEnumeration(message = "Must Gender Enum", enumClass = Gender.class)
  private Level level;

  private String institution;

  @StringEnumeration(message = "Must Final Score Enum", enumClass = FinalScoreType.class)
  private String finalScoreType;

  private Double finalScore;
}
