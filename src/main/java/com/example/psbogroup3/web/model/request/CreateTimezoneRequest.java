package com.example.psbogroup3.web.model.request;

import com.example.psbogroup3.validation.TimezoneMustValid;
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
    @NotBlank
    @TimezoneMustValid(message = "Must Valid Location", path = "location")
    private String location;
}
