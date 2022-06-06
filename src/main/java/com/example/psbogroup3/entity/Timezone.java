package com.example.psbogroup3.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author alvinamaharani
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("timezone")
public class Timezone {
    @Id
    private String id;
    private String offset;
    private String location;
}
