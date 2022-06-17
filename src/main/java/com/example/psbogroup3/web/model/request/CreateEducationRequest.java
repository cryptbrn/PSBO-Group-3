package com.example.psbogroup3.web.model.request;

import com.example.psbogroup3.enums.FinalScoreType;
import com.example.psbogroup3.enums.Level;
import com.example.psbogroup3.validation.StringEnumeration;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Linz_is_here
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEducationRequest {
  @NotNull
  private Level level;

  @NotBlank
  private String institution;

  @NotNull
  @StringEnumeration(message = "Must Final Score Enum", enumClass = FinalScoreType.class)
  private String finalScoreType;

  @NotNull
  private Double finalScore;
}
