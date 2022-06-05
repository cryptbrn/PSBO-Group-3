package com.example.psbogroup3.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobRequest {
    @NotBlank
    private String institution;

    @NotBlank
    private String position;

    @NotBlank
    private double salary;

    @NotBlank
    private String joinDate;
}
