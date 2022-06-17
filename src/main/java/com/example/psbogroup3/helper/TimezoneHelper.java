package com.example.psbogroup3.helper;

import com.example.psbogroup3.entity.Timezone;
import com.example.psbogroup3.web.model.request.CreateTimezoneRequest;
import com.example.psbogroup3.web.model.request.UpdateTimezoneRequest;
import com.example.psbogroup3.web.model.response.TimezoneResponse;

/**
 * @author muhammad.reyhan
 */
public interface TimezoneHelper {

  String generateOffset(String location);

  Timezone toTimezone(CreateTimezoneRequest createTimezoneRequest);

  TimezoneResponse toResponse(Timezone timezone);

  Timezone updateTimezone(Timezone timezone, UpdateTimezoneRequest updateTimezoneRequest);

}
