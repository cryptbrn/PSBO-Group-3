package com.example.psbogroup3.web.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class CreateAddressRequest {
    @NotBlank
    private String houseNum;

    @NotBlank
    private String street;

    @NotBlank
    private String subDistrict;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String province;

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    @NotNull
    @Valid
    private CreateTimezoneRequest timezoneRequest;
}
