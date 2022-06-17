package com.example.psbogroup3.web.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobRequest {
    @NotBlank
    private String institution;

    @NotBlank
    private String position;

    @NotNull
    private Double salary;

    @NotNull
    private Long joinDate;
}
