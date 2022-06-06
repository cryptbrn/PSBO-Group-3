package com.example.psbogroup3.web.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author alvinamaharani
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTimezoneRequest {
    //@StringEnumeration(message = "Must Location Enum", enumClass = Location.class)
    private String location;
}
