package com.example.psbogroup3.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
