package com.example.psbogroup3.web.controller;

import com.example.psbogroup3.entity.Education;
import com.example.psbogroup3.helper.EducationHelper;
import com.example.psbogroup3.helper.ObjectHelper;
import com.example.psbogroup3.repository.EducationRepository;
import com.example.psbogroup3.validation.EducationMustExist;
import com.example.psbogroup3.web.model.request.CreateEducationRequest;
import com.example.psbogroup3.web.model.request.UpdateEducationRequest;
import com.example.psbogroup3.web.model.response.EducationResponse;
import com.example.psbogroup3.web.model.response.Response;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
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
 * @author muhammad.reyhan
 */

@Api
@Validated
@RestController
public class EducationController {

  @Autowired
  EducationRepository educationRepository;

  @Autowired
  EducationHelper educationHelper;

  @Autowired
  ObjectHelper objectHelper;


  @GetMapping(
      value = "/api/educations",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Response<List<EducationResponse>> findAll() {
    List<Education> educationList = educationRepository.findAll();
    List<EducationResponse> educationResponseList = educationList.stream()
        .map(education -> educationHelper.toResponse(education)).collect(
            Collectors.toList());
    return Response.<List<EducationResponse>>builder()
        .status(true)
        .data(educationResponseList)
        .build();

  }

  @GetMapping(
      value = "/api/educations/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Response<EducationResponse> findById(
      @EducationMustExist(message = "Must Exist", path = "id")
      @PathVariable
      String id
  ) {
    Education education = educationRepository.findById(id).get();
    return Response.<EducationResponse>builder()
        .status(true)
        .data(educationHelper.toResponse(education))
        .build();
  }

  @PostMapping(
      value = "/api/educations",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Response<EducationResponse> create(
      @Validated @RequestBody CreateEducationRequest createEducationRequest) {
    Education education = educationRepository.save(educationHelper.toEducation(createEducationRequest));
    return Response.<EducationResponse>builder()
        .status(true)
        .data(educationHelper.toResponse(education))
        .build();
  }

  @PutMapping(
      value = "/api/educations/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Response<EducationResponse> updateById(
      @Validated
      @RequestBody
      UpdateEducationRequest updateEducationRequest,
      @EducationMustExist(message = "Must Exist", path = "id")
      @PathVariable
      String id
  ) {
    Education education = educationRepository.findById(id).get();
    objectHelper.copyProperties(updateEducationRequest, education);
    return Response.<EducationResponse>builder()
        .status(true)
        .data(educationHelper.toResponse(educationRepository.save(education)))
        .build();
  }

  @DeleteMapping(
      value = "/api/educations/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Response<String> deleteById(
      @EducationMustExist(message = "Must Exist", path = "id")
      @PathVariable
      String id
  ) {
    educationRepository.deleteById(id);
    return Response.<String>builder()
        .status(true)
        .data("Success Delete Education")
        .build();
  }

}
