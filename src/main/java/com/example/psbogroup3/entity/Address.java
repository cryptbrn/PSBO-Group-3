package com.example.psbogroup3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author maxdha.maxiwinata
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("address")
public class Address {
    @Id
    private String id;

    private String houseNum;

    private String street;

    private String subDistrict;

    private String district;

    private String city;

    private String province;

    private Double longitude;

    private Double latitude;

    private Double timezone;
}
