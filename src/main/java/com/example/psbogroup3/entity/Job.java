package com.example.psbogroup3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("job")

public class Job {
    @Id
    private String id;

    private String institution;

    private String position;

    private Double salary;

    private Long joinDate;
}
