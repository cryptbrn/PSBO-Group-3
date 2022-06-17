package com.example.psbogroup3.helper.impl;

import com.example.psbogroup3.entity.Education;
import com.example.psbogroup3.enums.FinalScoreType;
import com.example.psbogroup3.helper.EducationHelper;
import com.example.psbogroup3.web.model.request.CreateEducationRequest;
import com.example.psbogroup3.web.model.response.EducationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author muhammad.reyhan
 */
@Component
@Slf4j
public class EducationHelperImpl implements EducationHelper {

  @Override
  public Education toEducation(CreateEducationRequest createEducationRequest) {
    Education education = Education.builder().build();
    BeanUtils.copyProperties(createEducationRequest, education);
    education.setFinalScoreType(FinalScoreType.valueOf(createEducationRequest.getFinalScoreType()));
    return education;
  }

  @Override
  public EducationResponse toResponse(Education education) {
    EducationResponse educationResponse = EducationResponse.builder().build();
    BeanUtils.copyProperties(education, educationResponse);
    return educationResponse;
  }

}
