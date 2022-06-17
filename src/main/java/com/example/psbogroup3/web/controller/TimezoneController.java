package com.example.psbogroup3.web.controller;

import com.example.psbogroup3.entity.Timezone;
import com.example.psbogroup3.helper.ObjectHelper;
import com.example.psbogroup3.helper.TimezoneHelper;
import com.example.psbogroup3.repository.TimezoneRepository;
import com.example.psbogroup3.validation.TimezoneMustExist;
import com.example.psbogroup3.web.model.request.CreateTimezoneRequest;
import com.example.psbogroup3.web.model.request.UpdateTimezoneRequest;
import com.example.psbogroup3.web.model.response.Response;
import com.example.psbogroup3.web.model.response.TimezoneResponse;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alvinamaharani
 */

@Api
@Validated
@RestController
public class TimezoneController {

    @Autowired
    TimezoneRepository timezoneRepository;

    @Autowired
    ObjectHelper objectHelper;

    @Autowired
    TimezoneHelper timezoneHelper;

    @GetMapping(
            value = "/api/timezone",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<List<TimezoneResponse>> findAll(){
        List<Timezone> timezoneList = timezoneRepository.findAll();
        List<TimezoneResponse> timezoneResponseList = timezoneList.stream().map(this::toResponse).collect(
                Collectors.toList());
        return Response.<List<TimezoneResponse>>builder()
                .status(true)
                .data(timezoneResponseList)
                .build();
    }

    @GetMapping(
            value = "/api/timezone/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<TimezoneResponse> findById(
            @TimezoneMustExist(message = "Must Exist", path = "id")
            @PathVariable
            String id
    ){
        Timezone timezone = timezoneRepository.findById(id).get();
        return Response.<TimezoneResponse>builder()
                .status(true)
                .data(toResponse(timezone))
                .build();
    }

    @PostMapping(
            value = "/api/timezone",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<TimezoneResponse> create(@Validated @RequestBody CreateTimezoneRequest createTimezoneRequest){
        Timezone timezone = timezoneRepository.save(toTimezone(createTimezoneRequest));
        System.out.println(timezone);
        return Response.<TimezoneResponse>builder()
                .status(true)
                .data(toResponse(timezone))
                .build();
    }

    @PutMapping(
            value = "/api/timezone/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<TimezoneResponse> updateById(
            @Validated
            @RequestBody
            UpdateTimezoneRequest updateTimezoneRequest,
            @TimezoneMustExist(message = "Must Exist", path = "id")
            @PathVariable
            String id
    ){
        Timezone timezone = timezoneRepository.findById(id).get();
        objectHelper.copyProperties(updateTimezoneRequest, timezone);
        timezone.setOffset(timezoneHelper.generateOffset(updateTimezoneRequest.getLocation()));
        return Response.<TimezoneResponse>builder()
                .status(true)
                .data(toResponse(timezoneRepository.save(timezone)))
                .build();
    }

    @DeleteMapping(
            value = "api/timezone/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<String> deleteById(
            @TimezoneMustExist(message = "Must Exist", path = "id")
            @PathVariable
            String id
    ){
        timezoneRepository.deleteById(id);
        return Response.<String>builder()
                .status(true)
                .data("Success Delete Timezone")
                .build();
    }

    private TimezoneResponse toResponse(Timezone timezone){
        TimezoneResponse timezoneResponse = TimezoneResponse.builder().build();
        BeanUtils.copyProperties(timezone, timezoneResponse);
        return timezoneResponse;
    }

    private Timezone toTimezone(CreateTimezoneRequest createTimezoneRequest){
        Timezone timezone = Timezone.builder().build();
        BeanUtils.copyProperties(createTimezoneRequest, timezone);
        timezone.setOffset(timezoneHelper.generateOffset(createTimezoneRequest.getLocation()));
        return timezone;
    }

}
