package com.example.psbogroup3.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobRequest {

    private String institution;

    private String position;

    private Double salary;

    private Long joinDate;

}
