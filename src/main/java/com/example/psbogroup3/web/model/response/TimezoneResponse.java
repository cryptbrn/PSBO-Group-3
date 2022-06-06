package com.example.psbogroup3.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimezoneResponse {
    private String id;
    private String offset;
    private String location;
}
