package com.example.psbogroup3.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author muhammad.reyhan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {
    private String houseNum;

    private String street;

    private String subDistrict;

    private String district;

    private String city;

    private String province;

    private Double _long;

    private Double lat;

    private Double timezone;
}
