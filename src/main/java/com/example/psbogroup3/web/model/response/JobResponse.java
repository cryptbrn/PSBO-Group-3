package com.example.psbogroup3.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
    private String institution;
    private String position;
    private double salary;
    private String joinDate;
}
