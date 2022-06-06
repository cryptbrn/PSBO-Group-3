package com.example.psbogroup3.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author alvinamaharani
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTimezoneRequest {
    @NotNull
    //@StringEnumeration(message = "Must Location Enum", enumClass = Location.class)
    private String location;
}
