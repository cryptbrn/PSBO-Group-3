package com.example.psbogroup3.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maxdha.Maxiwinata
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String id;
    private String houseNum;
    private String street;
    private String subDistrict;
    private String district;
    private String city;
    private String province;
    private Double longitude;
    private Double latitude;
    private TimezoneResponse timezone;
}
